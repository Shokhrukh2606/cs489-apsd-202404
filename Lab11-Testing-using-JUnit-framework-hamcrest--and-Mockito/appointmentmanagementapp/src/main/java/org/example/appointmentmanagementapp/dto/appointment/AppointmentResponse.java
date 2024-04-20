package org.example.appointmentmanagementapp.dto.appointment;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.appointmentmanagementapp.model.Dentist;
import org.example.appointmentmanagementapp.model.Patient;
import org.example.appointmentmanagementapp.model.Surgery;

import java.time.LocalDate;

public record AppointmentResponse (
        LocalDate date,
        Double bill,
        LocalDate billDueDate,
        Boolean isPaid,
        String dentistName,
        String surgeryName
){ }
