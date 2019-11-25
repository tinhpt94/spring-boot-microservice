package com.tinhpt.authservice.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Override
    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
