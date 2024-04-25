package org.example.pdmapp.service;

import org.example.pdmapp.dto.LeaseRequestDto;
import org.example.pdmapp.model.Lease;

import java.util.List;

public interface LeaseService {
    List<Lease> findAllLeases();
    List<Lease> findAllLeasesByPropertyId(Long propertyId);
    List<Lease> findAllByState(String state);
    Lease registerLease(Long propertyId, LeaseRequestDto newLease);
}
