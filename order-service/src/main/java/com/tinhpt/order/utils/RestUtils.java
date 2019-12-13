package com.tinhpt.order.utils;

import com.tinhpt.order.config.JwtConfig;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;

public class RestUtils {
    public static HttpEntity createHttpHeaderEntity(JwtConfig jwtConfig) {
        String token = JwtUtils.generateToken(SecurityContextHolder.getContext().getAuthentication(), jwtConfig);
        HttpHeaders headers = new HttpHeaders();
        headers.add(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
        return new HttpEntity(headers);
    }
}
