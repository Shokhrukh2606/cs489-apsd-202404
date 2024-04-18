package org.example.rentacar.controller;

import jakarta.validation.Valid;
import org.example.rentacar.dto.CustomerDTO;
import org.example.rentacar.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
public class UserConroller {
    private final UserService userService;
    public UserConroller(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> registerUser(@Valid @RequestBody CustomerDTO newUser) throws Exception {
        CustomerDTO user=userService.registerUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
