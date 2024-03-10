package com.example.madrassaty.dtos.request;

import com.example.madrassaty.enums.StatusType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDTO {

    private long id;
    @NotEmpty(message = "firstname can't be empty")
    @NotNull(message = "firstname is required")
    private String firstname;
    @NotEmpty(message = "lastname can't be empty")
    @NotNull(message = "lastname is required")
    private String lastname;
    @NotEmpty(message = "email can't be empty")
    @NotNull(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "password can't be empty")
    @NotNull(message = "password is required")
    @Size(message = "password must be at least 8 characters and less than 16", min = 8, max = 15)
    private String password;
    private StatusType status;
    private String city;
    private String address;
    private MultipartFile image;

}
