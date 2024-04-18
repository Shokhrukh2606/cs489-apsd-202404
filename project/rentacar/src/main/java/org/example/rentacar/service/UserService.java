package org.example.rentacar.service;

import org.example.rentacar.dto.CustomerDTO;

public interface UserService {
    CustomerDTO registerUser(CustomerDTO user) throws Exception;
}
