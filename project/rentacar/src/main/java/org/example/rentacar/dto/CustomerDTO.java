package org.example.rentacar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
//    @NotBlank
    private String firstName;
//    @NotBlank
    private String lastName;
//    @NotBlank
    private String emailAddress;
//    @NotBlank
    private String phoneNumber;
//    @NotBlank
    private String avatarUrl;
    private AddressDto address;
    private String driverLicenseNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
}
