package org.example.rentacar.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@DiscriminatorValue("INVENTORY_COORDINATOR")
public class InventoryCoordinator extends User{
    @Override
    public UserType getType() {
        return UserType.INVENTORY_COORDINATOR;
    }
}
