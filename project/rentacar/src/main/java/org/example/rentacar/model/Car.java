package org.example.rentacar.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    private int year;
    private int seatsNumber;
    @Column(nullable = false)
    private String imageUrl;
    private String garageNumber;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="car_feature", joinColumns = @JoinColumn(name = "car_id", nullable = false), uniqueConstraints = @UniqueConstraint(columnNames = {"car_id"}))
    private Set<Feature> features=new HashSet<>();

    private int numberOfBags;
    @Embedded
    @JsonUnwrapped
    private FuelEfficiency fuelEfficiency;
    @Column(nullable = false)
    private Double priceForDay;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", unique = false)
    private Category category;

    @OneToMany(mappedBy = "car")
    private List<CarItem> carItems;
}
