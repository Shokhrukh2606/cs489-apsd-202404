package org.example.rentacar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
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
    private String password;
}
