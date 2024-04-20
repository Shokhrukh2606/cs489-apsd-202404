package org.example.rentacar.service.impl;

import lombok.AllArgsConstructor;
import org.example.rentacar.dto.LoginRequestDto;
import org.example.rentacar.dto.LoginResponseDto;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.security.JwtHelper;
import org.example.rentacar.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private JwtHelper jwtHelper;
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;


    @Override
    public LoginResponseDto signin(LoginRequestDto loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return new LoginResponseDto(jwtHelper.generateToken(loginRequest.getUsername()));
    }
}
