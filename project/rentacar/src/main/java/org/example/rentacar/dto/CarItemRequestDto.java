package org.example.rentacar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarItemRequestDto {
    private Long id;
    private Long carId;
    private String plateNumber;
    private String vinNumber;
    private String garageSection;
}
