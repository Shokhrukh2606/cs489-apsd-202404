package org.example.appointmentmanagementapp.dto.patient;

import jakarta.persistence.*;
import org.example.appointmentmanagementapp.dto.address.AddressResponse;
import org.example.appointmentmanagementapp.model.Address;
import org.example.appointmentmanagementapp.model.Appointment;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record PatientResponse(
        String firstName,
        String lastName,
        String contactPhoneNumber,
        String email,
        LocalDate dateOfBirth,
        AddressResponse mailingAddress
) {}
