package org.example.appointmentmanagementapp.service.impl.impl;

import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.example.appointmentmanagementapp.model.Patient;
import org.example.appointmentmanagementapp.repository.PatientRepository;
import org.example.appointmentmanagementapp.service.impl.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Patient> patientsList() {
        return patientRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Patient getPatientById(Long id) throws PatientNotFoundException {
        return patientRepository.findById(id).orElseThrow(
                ()->new PatientNotFoundException(
                        String.format("Error: Patient with Id %d, is not found", id)
                )
        );
    }

    @Override
    public Patient updatePatientById(Long id, Patient updatedPatient) throws PatientNotFoundException {
        var patient=patientRepository.findById(id).orElseThrow(
                ()->new PatientNotFoundException(
                        String.format("Error: Patient with Id %d, is not found", id)
                )
        );
        var address=patient.getMailingAddress();
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setContactPhoneNumber(updatedPatient.getContactPhoneNumber());
        patient.setEmail(updatedPatient.getEmail());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        address.setStreet(updatedPatient.getMailingAddress().getStreet());
        address.setCity(updatedPatient.getMailingAddress().getCity());
        address.setState(updatedPatient.getMailingAddress().getState());
        address.setZipCode(updatedPatient.getMailingAddress().getZipCode());
        return patientRepository.save(patient);
    }

    @Override
    public void deletePublisherById(Long id) throws PatientNotFoundException {
        var patient=patientRepository.findById(id).orElseThrow(
                ()->new PatientNotFoundException(
                        String.format("Error: Patient with Id %d, is not found", id)
                )
        );
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> searchPatientsList(String search) {
        return patientRepository.findPatientsByFirstNameContainingOrLastNameContainingOrContactPhoneNumberContainingOrEmailContainingOrMailingAddress_StreetContainingOrMailingAddress_CityContainingOrMailingAddress_StateContainingOrMailingAddress_ZipCodeContaining(
                search,
                search,
                search,
                search,
                search,
                search,
                search,
                search
        );
    }

}
