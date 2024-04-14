package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findAllByOrderByLastNameAsc();
    public List<Patient> findPatientsByFirstNameContainingOrLastNameContainingOrContactPhoneNumberContainingOrEmailContainingOrMailingAddress_StreetContainingOrMailingAddress_CityContainingOrMailingAddress_StateContainingOrMailingAddress_ZipCodeContaining(
            String firstName,
            String lastName,
            String contactPhoneNumber,
            String email,
            String street,
            String city,
            String state,
            String zipCode
    );
}
