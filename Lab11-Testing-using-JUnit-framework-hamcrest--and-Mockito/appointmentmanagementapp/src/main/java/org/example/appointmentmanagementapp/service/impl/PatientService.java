package org.example.appointmentmanagementapp.service.impl;

import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.example.appointmentmanagementapp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient registerPatient(Patient patient);
    List<Patient> patientsList();
    Patient getPatientById(Long id) throws PatientNotFoundException;
    Patient updatePatientById(Long id, Patient patient) throws PatientNotFoundException;
    void deletePublisherById(Long id) throws PatientNotFoundException;
    List<Patient> searchPatientsList(String search);
}
