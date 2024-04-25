package org.example.pdmapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class LeaseRequestDto {
    private Long leaseReferenceNumber;
    private LocalDate startDate;
    private LocalDate endDate;
}
