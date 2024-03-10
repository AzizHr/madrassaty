package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDTO {

    @NotEmpty(message = "email can't be empty")
    @NotNull(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "password can't be empty")
    @NotNull(message = "password is required")
    @Size(message = "password must be at least 8 characters and less than 16", min = 8, max = 15)
    private String password;

}
