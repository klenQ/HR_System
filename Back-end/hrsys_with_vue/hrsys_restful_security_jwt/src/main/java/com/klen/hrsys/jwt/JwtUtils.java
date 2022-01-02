package com.klen.hrsys.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description:
 * @Author: klenq
 * @CreateTime: 12/19/2021
 */
public class JwtUtils {
    /**
     * 生成token
     * @param authentication
     * @return
     */
    public static String generateToken(Authentication authentication){
        String token = Jwts.builder()
                .claim("authentication",authentication)
                .setSubject("主题")
                .setExpiration(new Date(System.currentTimeMillis()+60*60*24*1000))
                .signWith(SignatureAlgorithm.HS256,"klen")
                .compact();
        return token;
    }

    /**
     * 验证token
     * @param token
     */
    public static void tokenParser(String token) {

        //解析token
        Claims claims = Jwts.parser()
                .setSigningKey("klen")
                .parseClaimsJws(token)
                .getBody();
        //获取token过期时间
        Date claimsExpiration = claims.getExpiration();

        Date now = new Date();
        //判断是否expired
        if(now.getTime() > claimsExpiration.getTime()){

            throw new AuthenticationServiceException("token expired, please sign in again");

        }
        //将authentication认证取出
        LinkedHashMap authenticationMap = (LinkedHashMap<String, Object>) claims.get("authentication");

        //从认证中获取用户名
        String username = (String) authenticationMap.get("name");

        //获取权限信息
        ArrayList<LinkedHashMap<String, String>> authenticationList = (ArrayList<LinkedHashMap<String, String>>) authenticationMap.get("authorities");
        //转换权限信息为字符串数组
        String[] authenticationStr = new String[authenticationList.size()];
        for (int i = 0; i < authenticationList.size(); i++) {
            authenticationStr[i] = authenticationList.get(i).get("authority");
            
        }

        //将权限信息字符串转换成GrantedAuthority集合
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authenticationStr);

        //用户名和权限信息生成新的authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);

        //放入contextHolder, 表示认证通过
        SecurityContextHolder.getContext().setAuthentication(authentication);


    }

}
