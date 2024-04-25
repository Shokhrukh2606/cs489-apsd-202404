package org.example.pdmapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.pdmapp.dto.LeaseRequestDto;
import org.example.pdmapp.model.Lease;
import org.example.pdmapp.model.Property;
import org.example.pdmapp.service.LeaseService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("leases")
@RequiredArgsConstructor
public class LeaseController {
    private final LeaseService leaseService;
    @GetMapping
    public List<Lease> findAllLeases(){
        return leaseService.findAllLeases().stream().sorted(Comparator.comparing(Lease::getLeaseReferenceNumber, Comparator.reverseOrder())).toList();
    }
    @PostMapping(value = "/{property_id}")
    public Lease registerLease(@PathVariable Long property_id,@RequestBody LeaseRequestDto leaseRequestDto){
        return leaseService.registerLease(property_id, leaseRequestDto);
    }
    @GetMapping(value = "/revenue/{state}")
    public RevenueResponseDto findRevenue(@PathVariable String state){
        List<Lease> leases=leaseService.findAllByState(state);
        RevenueResponseDto revenueResponseDto=new RevenueResponseDto();
        revenueResponseDto.setState(state);
        revenueResponseDto.setProjectedTotalRevenue(leases.stream().mapToDouble(Lease::getTotalRevenue).sum());
        return revenueResponseDto;
    }
}
