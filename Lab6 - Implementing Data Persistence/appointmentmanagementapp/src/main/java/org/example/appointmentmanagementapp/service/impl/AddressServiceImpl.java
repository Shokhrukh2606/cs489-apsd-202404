package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.model.Address;
import org.example.appointmentmanagementapp.repository.AddressRepository;
import org.example.appointmentmanagementapp.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
}
