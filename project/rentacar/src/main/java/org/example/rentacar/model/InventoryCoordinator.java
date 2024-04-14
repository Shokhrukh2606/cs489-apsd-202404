package org.example.rentacar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INVENTORY_COORDINATOR")
public class InventoryCoordinator extends User{
    @Override
    public UserType getType() {
        return UserType.INVENTORY_COORDINATOR;
    }
}
