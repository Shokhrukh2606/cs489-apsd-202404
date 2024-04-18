package org.example.appointmentmanagementapp.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthRequest {
    @NotBlank(message = "Username can not be null, empty or blankspace(s)")
    private String username;
    @NotBlank(message = "Password can not be null, empty or blankspace(s)")
    private String password;
}
