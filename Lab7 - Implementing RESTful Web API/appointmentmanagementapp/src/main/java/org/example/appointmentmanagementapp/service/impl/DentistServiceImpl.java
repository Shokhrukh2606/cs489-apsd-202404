package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.model.Dentist;
import org.example.appointmentmanagementapp.repository.DentistRepository;
import org.example.appointmentmanagementapp.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository dentistRepository;
    public DentistServiceImpl(DentistRepository dentistRepository){
        this.dentistRepository=dentistRepository;
    }
    @Override
    public Dentist registerDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}
