package org.example.appointmentmanagementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double bill;
    private LocalDate billDueDate;
    private Boolean isPaid;
    @ManyToOne
    @JoinColumn(name = "dentist_id", unique = false)
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name = "patient_id", unique = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "surgery_id", unique = false)
    private Surgery surgery;
    @Override
    public String toString(){
        return String.format("{\"dentist\": \"%s\", \"patient\": \"%s\", \"surgery\": %s, \"appointmentDate\": %s }",
                this.getDentist().getFirstName()+this.getDentist().getLastName(),
                this.getPatient().getFirstName()+this.getPatient().getLastName(),
                this.getSurgery().getName(),
                this.date
                );
    }
}
