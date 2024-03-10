package com.example.madrassaty.dtos.response;

import com.example.madrassaty.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private String image;
    private String token;
}
