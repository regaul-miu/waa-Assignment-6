package miu.waa.assignment6.service;

import miu.waa.assignment6.domain.dto.request.LoginRequest;
import miu.waa.assignment6.domain.dto.request.RefreshTokenRequest;
import miu.waa.assignment6.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
