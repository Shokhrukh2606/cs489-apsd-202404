package org.example.rentacar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto {
    private String make;
    private String model;
    private int year;
    private int seatsNumber;
    private int numberOfBags;
    private String imageUrl;
    private String garageNumber;
    private Set<FeatureDto> features;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fuelEfficiency")
    private FuelEfficiencyDto fuelEfficiency;
    private CategoryDto category;
}
