package org.example.rentacar.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FuelEfficiency {
    private int city;
    private int highway;
    private int mixed;
}
