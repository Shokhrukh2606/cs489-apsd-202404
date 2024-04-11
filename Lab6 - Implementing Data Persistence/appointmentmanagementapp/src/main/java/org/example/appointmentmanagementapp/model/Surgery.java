package org.example.appointmentmanagementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 12)
    private String telephoneNumber;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;

    public Surgery(Long id, String telephoneNumber, String name, Address address) {
        this.id=id;
        this.telephoneNumber=telephoneNumber;
        this.name=name;
        this.address=address;
    }
}
