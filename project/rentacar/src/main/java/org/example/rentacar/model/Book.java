package org.example.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
    @ManyToOne
    @JoinColumn(name = "caritem_id", unique = false)
    private CarItem carItem;
    @ManyToOne
    @JoinColumn(name = "customer_id", unique = false)
    private Customer customer;
    private boolean isDeleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", unique = true)
    private Invoice invoice;
}
