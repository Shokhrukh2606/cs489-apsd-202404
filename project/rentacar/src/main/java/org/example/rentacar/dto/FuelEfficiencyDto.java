package org.example.rentacar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class FuelEfficiencyDto {
    @JsonProperty("city")
    private int city;
    @JsonProperty("highway")
    private int highway;
    @JsonProperty("mixed")
    private int mixed;
}
