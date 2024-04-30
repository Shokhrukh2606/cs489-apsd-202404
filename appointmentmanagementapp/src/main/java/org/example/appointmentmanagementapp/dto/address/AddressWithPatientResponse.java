package org.example.appointmentmanagementapp.dto.address;

import org.example.appointmentmanagementapp.dto.patient.PatientSoftResponse;
import org.example.appointmentmanagementapp.model.Patient;

public record AddressWithPatientResponse(
        String street,
        String city,
        String state,
        String zipCode,
        PatientSoftResponse patientSoftResponse
) {
}
