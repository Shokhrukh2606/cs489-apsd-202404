package org.example.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique=true)
    public Address address;
    @Column(nullable = false, unique = true)
    private String driverLicenseNumber;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Override
    public UserType getType() {
        return UserType.CUSTOMER;
    }
    @OneToMany(mappedBy = "customer")
    private List<Book> books;
}
