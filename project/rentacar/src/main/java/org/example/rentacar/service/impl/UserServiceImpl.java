package org.example.rentacar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.rentacar.dto.CustomerDTO;
import org.example.rentacar.mapper.CustomerMapper;
import org.example.rentacar.model.*;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final CustomerMapper customerMapper;
    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper, CustomerMapper customerMapper){
        this.userRepository=userRepository;
        this.objectMapper=objectMapper;
        this.customerMapper = customerMapper;
    }
    @Override
    public CustomerDTO registerUser(CustomerDTO newUser) throws Exception {
        User user=null;
//        if(Objects.equals(newUser.getUsertype(), "CUSTOMER"))
            user=objectMapper.convertValue(newUser, Customer.class);
            System.out.println(user.toString());
//        else if(Objects.equals(newUser.getUsertype(), "INVENTORY_COORDINATOR"))
//            user=objectMapper.convertValue(newUser, InventoryCoordinator.class);
//        else if(Objects.equals(newUser.getUsertype(), "RENTAL_AGENT"))
//            user=objectMapper.convertValue(newUser, RentalAgent.class);
        if (user == null) throw new Exception("User type is not provided!");
        return customerMapper.toDto((Customer) userRepository.save(user));
    }
}
