package org.example.finalmock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "retirement_plans")
public class RetirementPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    @Column(nullable = false, unique = true)
    private String referenceNumber;
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private LocalDate retirementDate;
    private Double monthlyContribution;
}
