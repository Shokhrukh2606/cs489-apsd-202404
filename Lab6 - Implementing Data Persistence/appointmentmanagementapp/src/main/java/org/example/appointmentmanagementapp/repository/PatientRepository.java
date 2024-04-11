package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
