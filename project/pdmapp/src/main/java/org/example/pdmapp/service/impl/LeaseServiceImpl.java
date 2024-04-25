package org.example.pdmapp.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.pdmapp.dto.LeaseRequestDto;
import org.example.pdmapp.model.Lease;
import org.example.pdmapp.model.Property;
import org.example.pdmapp.repository.LeaseRepository;
import org.example.pdmapp.repository.PropertyRepository;
import org.example.pdmapp.service.LeaseService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {
    private final LeaseRepository leaseRepository;
    private final PropertyRepository propertyRepository;
    @Override
    public List<Lease> findAllLeases() {
        return leaseRepository.findAll();
    }

    @Override
    public List<Lease> findAllLeasesByPropertyId(Long propertyId) {
        return leaseRepository.findAllByPropertyPropertyId(propertyId);
    }

    @Override
    public List<Lease> findAllByState(String state) {
        return leaseRepository.findAllByPropertyState(state);
    }

    @Override
    public Lease registerLease(Long propertyId, LeaseRequestDto newLease) {
        Property property=propertyRepository.findById(propertyId).orElseThrow(()->new EntityNotFoundException(String.format("Property with id %d not found", propertyId)));
        return leaseRepository.save(new Lease(null, newLease.getLeaseReferenceNumber(), newLease.getStartDate(), newLease.getEndDate(), property));
    }
}
