package org.example.rentacar.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.rentacar.model.User;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmailAddress(username).orElseThrow(()->new EntityNotFoundException(String.format("User with email %s not found", username)));
        return new MyUserDetails(user);
    }
}
