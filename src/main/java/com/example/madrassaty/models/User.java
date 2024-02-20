package com.example.madrassaty.models;

import com.example.madrassaty.enums.Role;
import com.example.madrassaty.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private StatusType status;
    private String city;
    private String address;
    private String image;
    @Enumerated(EnumType.STRING)
    private Role role;

}
