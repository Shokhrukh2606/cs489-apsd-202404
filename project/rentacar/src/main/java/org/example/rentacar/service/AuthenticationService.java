package org.example.rentacar.service;

import org.example.rentacar.dto.LoginRequestDto;
import org.example.rentacar.dto.LoginResponseDto;
import org.example.rentacar.dto.RegisterRequestDto;
import org.example.rentacar.model.User;

public interface AuthenticationService {
    LoginResponseDto signin(LoginRequestDto loginRequest);
    User signup(RegisterRequestDto registerRequest) throws Exception;
}