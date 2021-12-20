package com.klen.hrsys.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klen.hrsys.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: klenq
 * @CreateTime: 12/19/2021
 */
@Component("jwtLoginSuccessHandler")
public class JwtLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String token = JwtUtils.generateToken(authentication);
        response.setContentType("application/json;charset=UTF-8");

        ServerResponse sr = new ServerResponse();
        sr.setCode(1);
        sr.setAuthorization(token);

        String s = objectMapper.writeValueAsString(sr);

        response.getWriter().write(s);
    }
}
