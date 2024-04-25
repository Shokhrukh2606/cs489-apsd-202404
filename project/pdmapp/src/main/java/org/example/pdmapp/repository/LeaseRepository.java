package org.example.pdmapp.repository;

import org.example.pdmapp.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findAllByPropertyPropertyId(Long propertyId);
    List<Lease> findAllByPropertyState(String state);
}
