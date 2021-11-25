package com.klen.hrsys.config;

import com.klen.hrsys.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/24
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

//    private PasswordEncoder encoder = new PasswordEncoder() {
//        // 明文加密，直接与数据库中的密码match
//        @Override
//        public String encode(CharSequence charSequence) {
//            return charSequence.toString();
//        }
//
//        @Override
//        public boolean matches(CharSequence charSequence, String s) {
//            return s.equals(charSequence.toString());
//        }
//    };
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/index")
                .failureUrl("/loginError")
                .permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and().authorizeRequests()
                .antMatchers("/dep/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated().and().exceptionHandling().accessDeniedPage("/roleError")
                .and().headers().frameOptions().sameOrigin()
                //取消阻止跨站请求伪造, 否则会造成开发不便利
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**","/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("aaa").password("111")//.roles("ADMIN")
                .and().withUser("bbb").password("111");//.roles("CUSTOMER");*/

        auth.userDetailsService(userDetailService).passwordEncoder(encoder);

    }

}
