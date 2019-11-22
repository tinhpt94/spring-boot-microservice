package com.tinhpt.authservice.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditHelper {
    public static String getCurrentAuditor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return ((UserDetails)authentication.getPrincipal()).getUsername();
    }
}
