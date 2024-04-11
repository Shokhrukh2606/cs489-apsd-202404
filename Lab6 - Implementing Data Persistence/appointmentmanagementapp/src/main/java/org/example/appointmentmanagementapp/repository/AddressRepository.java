package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
