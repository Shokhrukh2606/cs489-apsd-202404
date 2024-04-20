package org.example.rentacar.service;

import org.example.rentacar.dto.LoginRequestDto;
import org.example.rentacar.dto.LoginResponseDto;

public interface AuthenticationService {
    LoginResponseDto signin(LoginRequestDto loginRequest);
}