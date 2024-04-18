package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist,Long> {
}
