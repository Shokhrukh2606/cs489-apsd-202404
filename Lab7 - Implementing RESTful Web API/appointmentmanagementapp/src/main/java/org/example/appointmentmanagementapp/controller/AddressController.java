package org.example.appointmentmanagementapp.controller;

import org.example.appointmentmanagementapp.dto.address.AddressResponse;
import org.example.appointmentmanagementapp.dto.address.AddressWithPatientResponse;
import org.example.appointmentmanagementapp.dto.patient.PatientSoftResponse;
import org.example.appointmentmanagementapp.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/address")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<AddressWithPatientResponse>> listAddresses(){
        var addresses=addressService.addressesList();
        return ResponseEntity.ok(addresses.stream().map(
                i->{
                    var patient=i.getPatient();
                    if(patient!=null){
                        return new AddressWithPatientResponse(
                                i.getStreet(),
                                i.getCity(),
                                i.getState(),
                                i.getZipCode(),
                                new PatientSoftResponse(
                                        patient.getFirstName(),
                                        patient.getLastName(),
                                        patient.getContactPhoneNumber(),
                                        patient.getEmail(),
                                        patient.getDateOfBirth()
                                )
                        );
                    }
                    return new AddressWithPatientResponse(
                            i.getStreet(),
                            i.getCity(),
                            i.getState(),
                            i.getZipCode(),
                            null
                    );
                }
        ).toList());
    }
}
