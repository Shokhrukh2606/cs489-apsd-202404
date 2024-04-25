package org.example.pdmapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    @NotNull
    @Column(nullable = false)
    private String propertyRef;
    private String city;
    private String state;
    @NotNull
    @Column(nullable = false)
    private Double monthlyRate;
    @OneToMany(mappedBy = "property")
    @JsonBackReference
    private List<Lease> leases;
}
