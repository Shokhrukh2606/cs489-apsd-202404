package org.example.appointmentmanagementapp.service.impl.impl;

import org.example.appointmentmanagementapp.model.Surgery;
import org.example.appointmentmanagementapp.repository.SurgeryRepository;
import org.example.appointmentmanagementapp.service.impl.SurgeryService;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;
    public SurgeryServiceImpl(SurgeryRepository surgeryRepository){
        this.surgeryRepository=surgeryRepository;
    }
    @Override
    public Surgery createSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

}
