package org.example.appointmentmanagementapp.controller;

import jakarta.validation.Valid;
import org.example.appointmentmanagementapp.dto.address.AddressResponse;
import org.example.appointmentmanagementapp.dto.appointment.AppointmentResponse;
import org.example.appointmentmanagementapp.dto.patient.PatientDetailResponse;
import org.example.appointmentmanagementapp.dto.patient.PatientRequest;
import org.example.appointmentmanagementapp.dto.patient.PatientResponse;
import org.example.appointmentmanagementapp.exception.PatientNotFoundException;
import org.example.appointmentmanagementapp.model.Address;
import org.example.appointmentmanagementapp.model.Patient;
import org.example.appointmentmanagementapp.service.impl.AddressService;
import org.example.appointmentmanagementapp.service.impl.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/patient")
public class PatientController {
    private PatientService patientService;
    private AddressService addressService;
    public PatientController(PatientService patientService, AddressService addressService){
        this.patientService=patientService;
        this.addressService=addressService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<PatientResponse>> listPatients(){
        var patients=patientService.patientsList().stream().map(i->new PatientResponse(
                i.getFirstName(),
                i.getLastName(),
                i.getContactPhoneNumber(),
                i.getEmail(),
                i.getDateOfBirth(),
                new AddressResponse(
                        i.getMailingAddress().getStreet(),
                        i.getMailingAddress().getCity(),
                        i.getMailingAddress().getState(),
                        i.getMailingAddress().getZipCode()
                )
        )).toList();
        return ResponseEntity.ok(patients);
    }

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<PatientDetailResponse> getPatientById(@PathVariable Long patientId)
            throws PatientNotFoundException {
        var patient=patientService.getPatientById(patientId);
        var appointmentsList=patient.getAppointments().stream().map(
                i->new AppointmentResponse(
                    i.getDate(),
                    i.getBill(),
                        i.getBillDueDate(),
                        i.getIsPaid(),
                        String.format("%s %s",i.getPatient().getFirstName(), i.getPatient().getLastName()),
                        i.getSurgery().getName()
                )
        ).toList();
        return ResponseEntity.ok(new PatientDetailResponse(
                patient.getFirstName(),
                patient.getLastName(),
                patient.getContactPhoneNumber(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                new AddressResponse(
                        patient.getMailingAddress().getStreet(),
                        patient.getMailingAddress().getCity(),
                        patient.getMailingAddress().getState(),
                        patient.getMailingAddress().getZipCode()
                ),
                appointmentsList
        ));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PatientResponse> registerNewPatient(@Valid @RequestBody PatientRequest patientRequest){
        var address=addressService.createAddress(
                new Address(
                        null,
                        patientRequest.mailingAddress().street(),
                        patientRequest.mailingAddress().city(),
                        patientRequest.mailingAddress().state(),
                        patientRequest.mailingAddress().zipCode()
                )
        );
        var patient=new Patient(
            null,
            patientRequest.firstName(),
            patientRequest.lastName(),
            patientRequest.contactPhoneNumber(),
            patientRequest.email(),
            patientRequest.dateOfBirth(),
            address
        );
        var newPatient=patientService.registerPatient(patient);
        return new ResponseEntity<>(
                new PatientResponse(
                        newPatient.getFirstName(),
                        newPatient.getLastName(),
                        newPatient.getContactPhoneNumber(),
                        newPatient.getEmail(),
                        newPatient.getDateOfBirth(),
                        new AddressResponse(
                                newPatient.getMailingAddress().getStreet(),
                                newPatient.getMailingAddress().getCity(),
                                newPatient.getMailingAddress().getState(),
                                newPatient.getMailingAddress().getZipCode()
                        )
                )
        , HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long patientId, @RequestBody PatientRequest patientRequest) throws PatientNotFoundException {
        var patient=patientService.updatePatientById(patientId,
                new Patient(
                        null,
                        patientRequest.firstName(),
                        patientRequest.lastName(),
                        patientRequest.contactPhoneNumber(),
                        patientRequest.email(),
                        patientRequest.dateOfBirth(),
                        new Address(
                                null,
                                patientRequest.mailingAddress().street(),
                                patientRequest.mailingAddress().city(),
                                patientRequest.mailingAddress().state(),
                                patientRequest.mailingAddress().zipCode()
                        )
                )
                );

        return new ResponseEntity<>( new PatientResponse(
                patient.getFirstName(),
                patient.getLastName(),
                patient.getContactPhoneNumber(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                new AddressResponse(
                        patient.getMailingAddress().getStreet(),
                        patient.getMailingAddress().getCity(),
                        patient.getMailingAddress().getState(),
                        patient.getMailingAddress().getZipCode()
                )
        ), HttpStatus.OK);
    }
    @DeleteMapping(value = "delete/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) throws PatientNotFoundException {
        patientService.deletePublisherById(patientId);
        return null;
    }
    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatient(@PathVariable String searchString){
        var patients=patientService.searchPatientsList(searchString).stream().map(
                i->new PatientResponse(
                        i.getFirstName(),
                        i.getLastName(),
                        i.getContactPhoneNumber(),
                        i.getEmail(),
                        i.getDateOfBirth(),
                        new AddressResponse(
                                i.getMailingAddress().getStreet(),
                                i.getMailingAddress().getCity(),
                                i.getMailingAddress().getState(),
                                i.getMailingAddress().getZipCode()
                        )
                )
        ).toList();
        return ResponseEntity.ok(
            patients
        );
    }

}
