package org.example.appointmentmanagementapp.controller.auth;

import jakarta.validation.Valid;
import org.example.appointmentmanagementapp.dto.auth.UserAuthRequest;
import org.example.appointmentmanagementapp.dto.auth.UserSignUpRequest;
import org.example.appointmentmanagementapp.model.Role;
import org.example.appointmentmanagementapp.model.User;
import org.example.appointmentmanagementapp.repository.RoleRepository;
import org.example.appointmentmanagementapp.repository.UserRepository;
import org.example.appointmentmanagementapp.utility.JWTManagementUtilityService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/service")
public class UserAuthController {
    private final JWTManagementUtilityService jwtManagementUtilityService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    public UserAuthController(
            JWTManagementUtilityService jwtManagementUtilityService,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            UserRepository userRepository){
        this.authenticationManager=authenticationManager;
        this.jwtManagementUtilityService=jwtManagementUtilityService;
        this.passwordEncoder=passwordEncoder;
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
    }
    @PostMapping(value = "/public/authenticate")
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(),
                            userAuthRequest.getPassword())
            );
        }catch (Exception exception){
            System.out.println("UserAuthException is: "+exception);
            System.out.println("Invalid Username and/or Password!");
            throw exception;
        }
        return jwtManagementUtilityService.generateToken(userAuthRequest.getUsername());
    }
    @PostMapping(value = "/public/authorize")
    public String authorizeUser(@Valid @RequestBody UserSignUpRequest userSignUpRequest) throws Exception {
        try{
            Role role=roleRepository.findByName("PATIENT").orElseThrow(()->new Exception("PATIENT ROLE DOES NOT EXIST!"));
            User newUser=new User(
                    null,
                    userSignUpRequest.getFirstName(),
                    userSignUpRequest.getLastName(),
                    userSignUpRequest.getContactPhoneNumber(),
                    userSignUpRequest.getEmail(),
                    passwordEncoder.encode(userSignUpRequest.getPassword()),
                    userSignUpRequest.getDateOfBirth(),
                    List.of(role),
                    true,
                    true,
                    true,
                    true
            );
            userRepository.save(newUser);
            return "Success";
        }catch (Exception e){
            System.out.println("User authorization is failed!");
            throw e;
        }
    }
}
