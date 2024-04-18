package org.example.appointmentmanagementapp.dto.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequest {
    @NotBlank(message = "First Name can not be null, empty or blankspace(s)")
    private String firstName;
    @NotBlank(message = "Last Name can not be null, empty or blankspace(s)")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Contact Phone Number can not be null, empty or blankspace(s)")
    private String contactPhoneNumber;
    @NotBlank(message = "Username can not be null, empty or blankspace(s)")
    private String email;
    @NotBlank(message = "Password can not be null, empty or blankspace(s)")
    private String password;
}
