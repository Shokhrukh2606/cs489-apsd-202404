package org.example.appointmentmanagementapp.dto.patient;

import java.time.LocalDate;

public record PatientSoftResponse(
        String firstName,
        String lastName,
        String contactPhoneNumber,
        String email,
        LocalDate dateOfBirth
) {
}
