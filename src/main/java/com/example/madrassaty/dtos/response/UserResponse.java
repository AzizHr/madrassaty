package com.example.madrassaty.dtos.response;

import com.example.madrassaty.enums.Role;
import com.example.madrassaty.enums.StatusType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private StatusType status;
    private String city;
    private String address;
    private String image;
    private Role role;
}
