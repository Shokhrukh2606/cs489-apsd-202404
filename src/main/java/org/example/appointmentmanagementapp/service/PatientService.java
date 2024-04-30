package org.example.appointmentmanagementapp.service;

import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.example.appointmentmanagementapp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient registerPatient(Patient patient);
    List<Patient> publishersList();
    Patient getPatientById(Long id) throws PatientNotFoundException;
    Patient updatePatientById(Long id, Patient patient) throws PatientNotFoundException;
    void deletePublisherById(Long id) throws PatientNotFoundException;
    List<Patient> searchPublishersList(String search);
}
