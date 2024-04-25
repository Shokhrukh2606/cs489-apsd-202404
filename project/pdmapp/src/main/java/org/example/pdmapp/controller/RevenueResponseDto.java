package org.example.pdmapp.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueResponseDto {
    private String state;
    private Double projectedTotalRevenue;
}
