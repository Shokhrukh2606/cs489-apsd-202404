package org.example.rentacar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RENTAL_AGENT")
public class RentalAgent extends User{
    @Override
    public UserType getType() {
        return UserType.RENTAL_AGENT;
    }
}
