package org.example.appointmentmanagementapp.repository;

import org.example.appointmentmanagementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public abstract Optional<User> findByEmail(String username);
}
