package org.example.pdmapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leases")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaseId;
    @NotNull
    @Column(nullable = false, unique = true)
    private Long leaseReferenceNumber;
    @NotNull
    @Column(nullable = false)
    private LocalDate startDate;
    @NotNull
    @Column(nullable = false)
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "propertyId", unique = false)
    @JsonManagedReference
    private Property property;
    @Transient
    public Double getTotalRevenue(){
        Long difference= ChronoUnit.MONTHS.between(this.startDate, this.endDate);
        return difference*this.getProperty().getMonthlyRate();
    }
}
