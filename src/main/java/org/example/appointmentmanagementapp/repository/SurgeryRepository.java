package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery,Long> {
}
