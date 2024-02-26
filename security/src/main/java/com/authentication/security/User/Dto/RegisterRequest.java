package com.authentication.security.User.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Firstname must be not Blank")
    private String firstname;
    @NotBlank(message = "Lastname must be not Blank")
    private  String lastname;
    @NotBlank(message = "Email must be not Blank")
    @Email(message = "email must be Email format")
    private String email;
    @NotBlank(message = "Password must be not Blank")
    private  String  password;
}
