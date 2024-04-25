package org.example.rentacar.controller;

import lombok.AllArgsConstructor;
import org.example.rentacar.dto.LoginRequestDto;
import org.example.rentacar.dto.LoginResponseDto;
import org.example.rentacar.dto.RegisterRequestDto;
import org.example.rentacar.model.Address;
import org.example.rentacar.model.Customer;
import org.example.rentacar.model.User;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.utility.JWTManagementUtilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UaaController {
    private final JWTManagementUtilityService jwtManagementUtilityService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDto> signin(@RequestBody LoginRequestDto loginRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword())
            );
        }catch (Exception exception){
            System.out.println("UserAuthException is: "+exception);
            System.out.println("Invalid Username and/or Password!");
            throw exception;
        }
        LoginResponseDto loginResponseDto=new LoginResponseDto(jwtManagementUtilityService.generateToken(loginRequest.getUsername()));
        return ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterRequestDto registerRequest) throws Exception {
        Customer newUser=new Customer();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setEmailAddress(registerRequest.getEmailAddress());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setPhoneNumber(registerRequest.getPhoneNumber());
        newUser.setAvatarUrl(registerRequest.getAvatarUrl());
        newUser.setAddress(new Address(null, registerRequest.getAddress().getStreet(), registerRequest.getAddress().getApt(), registerRequest.getAddress().getCity(), registerRequest.getAddress().getState(), registerRequest.getAddress().getZipCode()));
        newUser.setDriverLicenseNumber(registerRequest.getDriverLicenseNumber());
        newUser.setDateOfBirth(registerRequest.getDateOfBirth());
        userRepository.save(newUser);
        return ResponseEntity.ok(newUser);
    }
}
