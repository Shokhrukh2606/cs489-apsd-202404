package org.example.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique=true)
    public Address address;

    private String driverLicenseNumber;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;
    @Override
    public UserType getType() {
        return UserType.CUSTOMER;
    }
    @OneToMany(mappedBy = "customer")
    private List<Book> books;
}
