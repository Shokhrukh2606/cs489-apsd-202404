package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.model.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    List<Address> addressesList();
}
