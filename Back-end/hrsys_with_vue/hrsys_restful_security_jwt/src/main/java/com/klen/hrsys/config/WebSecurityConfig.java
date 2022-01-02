package com.klen.hrsys.config;

import com.klen.hrsys.jwt.JwtAuthenticationTokenFilter;
import com.klen.hrsys.jwt.JwtLoginFailureHandler;
import com.klen.hrsys.jwt.JwtLoginSuccessHandler;
import com.klen.hrsys.service.impl.UserDetailsServiceImpl;
import com.klen.hrsys.util.ServerResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //启用方法级别的权限认
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtLoginSuccessHandler jwtLoginSuccessHandler;
    @Autowired
    private JwtLoginFailureHandler jwtLoginFailureHandler;

    // 加入自定义的安全认证:数据库用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    //方法注解方式
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();

        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler(jwtLoginSuccessHandler)
                .failureHandler(jwtLoginFailureHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        printCode(httpServletResponse, 3);
                    }
                })
                .and().headers().frameOptions().sameOrigin()
                // .and().cors()
                .and().cors()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) {
        // 设置拦截忽略文件夹，对静态资源放行
        web.ignoring().antMatchers("/css/**","/font/**", "/js/**","/index.html");
    }

    private void printCode(HttpServletResponse httpServletResponse, Integer code) {
        try {
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            ServerResponse sr = new ServerResponse<>();
            sr.setCode(code);
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(sr);
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        //设置Spring Security Firewall规则,此处设置URL中允许双
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
}