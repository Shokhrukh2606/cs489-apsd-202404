package org.example.appointmentmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(length = 12, unique = true)
    private String contactPhoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="address_id", unique = true)
    @JsonManagedReference
    private Address mailingAddress;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(Long id, String firstName, String lastName, String contactPhoneNumber, String email, LocalDate dateOfBirth, Address address) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.contactPhoneNumber=contactPhoneNumber;
        this.email=email;
        this.dateOfBirth=dateOfBirth;
        this.mailingAddress=address;
    }
}
