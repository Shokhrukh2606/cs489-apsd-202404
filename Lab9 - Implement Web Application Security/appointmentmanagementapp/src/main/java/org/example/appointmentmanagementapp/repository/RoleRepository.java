package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public abstract Optional<Role> findByName(String name);
}
