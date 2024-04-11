package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.model.Dentist;
import org.example.appointmentmanagementapp.model.Patient;
import org.example.appointmentmanagementapp.repository.PatientRepository;
import org.example.appointmentmanagementapp.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    @Override
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
