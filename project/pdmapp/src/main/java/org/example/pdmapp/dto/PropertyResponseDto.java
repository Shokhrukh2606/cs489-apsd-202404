package org.example.pdmapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pdmapp.model.Lease;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponseDto {
    private String propertyRef;
    private String city;
    private String state;
    private Double monthlyRate;
    private List<Lease> leases;
}
