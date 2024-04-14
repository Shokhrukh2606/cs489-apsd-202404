package org.example.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private int year;
    private int seatsNumber;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="car_feature", joinColumns = @JoinColumn(name = "car_id", nullable = false), uniqueConstraints = @UniqueConstraint(columnNames = {"car_id"}))
    private Set<Feature> features=new HashSet<>();

    private int numberOfBags;
    @Embedded
    private FuelEfficiency fuelEfficiency;

    @ManyToOne
    @JoinColumn(name = "category_id", unique = false)
    private Category category;

    @OneToMany(mappedBy = "car")
    private List<CarItem> carItems;
}
