package org.example.appointmentmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    @Column(length = 16)
    private String zipCode;
    @OneToOne(mappedBy = "mailingAddress", fetch = FetchType.EAGER)
    @JsonBackReference
    private Patient patient;
    public Address(
            Long id,
            String street,
            String city,
            String state,
            String zipCode
    ){
        this.id=id;
        this.street=street;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
    }
}
