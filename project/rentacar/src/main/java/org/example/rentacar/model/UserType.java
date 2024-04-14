package org.example.rentacar.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserType {
    RENTAL_AGENT,INVENTORY_COORDINATOR,CUSTOMER
}
