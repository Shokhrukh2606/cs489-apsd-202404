package org.example.appointmentmanagementapp.dto.patient;

import org.example.appointmentmanagementapp.dto.address.AddressRequest;
import org.example.appointmentmanagementapp.dto.address.AddressResponse;

import java.time.LocalDate;

public record PatientRequest(
        String firstName,
        String lastName,
        String contactPhoneNumber,
        String email,
        LocalDate dateOfBirth,
        AddressRequest mailingAddress
) {}
