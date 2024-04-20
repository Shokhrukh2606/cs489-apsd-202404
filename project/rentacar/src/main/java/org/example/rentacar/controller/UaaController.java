package org.example.rentacar.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.rentacar.dto.LoginRequestDto;
import org.example.rentacar.dto.LoginResponseDto;
import org.example.rentacar.dto.RegisterRequestDto;
import org.example.rentacar.service.AuthenticationService;
import org.example.rentacar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@RequiredArgsConstructor
public class UaaController {
    private AuthenticationService authenticationService;
    private UserService userService;
    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDto> signin(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(authenticationService.signin(loginRequest));
    }

    @PostMapping("/signup")
    public User signup(@RequestBody RegisterRequestDto registerRequest) throws Exception {
        return userService.signup(registerRequest);
    }
}
