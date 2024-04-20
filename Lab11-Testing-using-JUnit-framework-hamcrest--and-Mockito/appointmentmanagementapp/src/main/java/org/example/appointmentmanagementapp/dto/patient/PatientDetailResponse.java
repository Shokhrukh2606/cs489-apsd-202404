package org.example.appointmentmanagementapp.dto.patient;

import org.example.appointmentmanagementapp.dto.address.AddressResponse;
import org.example.appointmentmanagementapp.dto.appointment.AppointmentResponse;

import java.time.LocalDate;
import java.util.List;

public record PatientDetailResponse (
    String firstName,
    String lastName,
    String contactPhoneNumber,
    String email,
    LocalDate dateOfBirth,
    AddressResponse mailingAddress,
    List<AppointmentResponse> appointmentResponseList
){}
