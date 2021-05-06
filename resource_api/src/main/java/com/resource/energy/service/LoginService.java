package com.resource.energy.service;

import com.resource.energy.request.LoginRequest;
import com.resource.energy.response.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request);

}
