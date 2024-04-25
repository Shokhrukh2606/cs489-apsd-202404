package org.example.pdmapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.pdmapp.dto.PropertyResponseDto;
import org.example.pdmapp.model.Lease;
import org.example.pdmapp.model.Property;
import org.example.pdmapp.service.LeaseService;
import org.example.pdmapp.service.PropertyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final LeaseService leaseService;
    @GetMapping(value = "/{state}")
    public List<PropertyResponseDto> findAllProperties(@PathVariable String state){
        return propertyService.listAllPropertiesByState(state).stream().map(i->{
            List<Lease> leases=leaseService.findAllLeasesByPropertyId(i.getPropertyId());
            return new PropertyResponseDto(i.getPropertyRef(), i.getCity(), i.getState(), i.getMonthlyRate(), leases);
        }).toList();
    }
}
