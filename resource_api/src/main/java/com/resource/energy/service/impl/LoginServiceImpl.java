package com.resource.energy.service.impl;

import com.resource.energy.domain.AppUser;
import com.resource.energy.request.LoginRequest;
import com.resource.energy.response.LoginResponse;
import com.resource.energy.service.AppUserService;
import com.resource.energy.service.LoginService;
import com.resource.energy.service.LoginUsernameService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final LoginUsernameService loginUsernameService;

    public LoginServiceImpl(AppUserService appUserService,
                            PasswordEncoder passwordEncoder,
                            LoginUsernameService loginUsernameService) {
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
        this.loginUsernameService = loginUsernameService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        String username = this.loginUsernameService.getLoginUsername();
        AppUser appUser =
                appUserService
                        .getRepository().findByUsername(request.getUserName());

        if (!request.getUserName().equals(username)){
            throw new BadCredentialsException("Bad Credentials - Invalid username or password");
        }

        if (!passwordEncoder.matches(request.getPassword(), appUser.getPassword())) {
            throw new BadCredentialsException("Bad Credentials - Invalid username or password");
        }

        return LoginResponse.builder()
                .responseCode("00")
                .responseMessage("Login successful")
                .build();
    }

}
