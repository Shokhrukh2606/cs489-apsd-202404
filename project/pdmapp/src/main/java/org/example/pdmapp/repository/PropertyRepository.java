package org.example.pdmapp.repository;

import org.example.pdmapp.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findAllByStateOrderByMonthlyRateAsc(String state);
}
