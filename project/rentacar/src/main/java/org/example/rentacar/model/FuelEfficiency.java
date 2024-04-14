package org.example.rentacar.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class FuelEfficiency {
    private double city;
    private double highway;
    private double mixed;
}
