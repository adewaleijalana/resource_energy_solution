package com.resource.energy.service.impl;

import com.resource.energy.service.LoginUsernameService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginUsernameServiceImpl implements LoginUsernameService {
    @Override
    public String getLoginUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        assert authentication != null;
        return authentication.getName();
    }
}
