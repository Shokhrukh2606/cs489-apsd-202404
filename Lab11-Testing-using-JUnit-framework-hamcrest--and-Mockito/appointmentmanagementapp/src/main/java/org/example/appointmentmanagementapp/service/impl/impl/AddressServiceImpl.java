package org.example.appointmentmanagementapp.service.impl.impl;

import org.example.appointmentmanagementapp.model.Address;
import org.example.appointmentmanagementapp.repository.AddressRepository;
import org.example.appointmentmanagementapp.service.impl.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Address> addressesList() {
        return addressRepository.findAllAddressWithPatientOrderByCityAsc();
    }
}
