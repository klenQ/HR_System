package com.klen.hrsys.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klen.hrsys.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: klenq
 * @CreateTime: 12/19/2021
 */
@Component("jwtLoginFailureHandler")
public class JwtLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        ServerResponse sr = new ServerResponse();
        sr.setCode(2);
        String s = objectMapper.writeValueAsString(sr);
        response.getWriter().write(s);
    }
}
