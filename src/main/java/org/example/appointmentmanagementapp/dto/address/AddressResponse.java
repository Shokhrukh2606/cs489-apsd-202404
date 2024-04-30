package org.example.appointmentmanagementapp.dto.address;

import jakarta.persistence.Column;

public record AddressResponse(
         String street,
         String city,
         String state,
         String zipCode
) {
}
