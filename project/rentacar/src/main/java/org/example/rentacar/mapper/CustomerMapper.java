package org.example.rentacar.mapper;

import org.example.rentacar.dto.CustomerDTO;
import org.example.rentacar.model.Customer;
import org.example.rentacar.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer user);
}
