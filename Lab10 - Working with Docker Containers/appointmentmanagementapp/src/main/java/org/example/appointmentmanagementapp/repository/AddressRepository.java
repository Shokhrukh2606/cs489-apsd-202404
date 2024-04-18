package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query(value = "select a.* from addresses a  left join patients p on a.id=p.address_id", nativeQuery = true)
    public List<Address> findAllAddressWithPatientOrderByCityAsc();
}
