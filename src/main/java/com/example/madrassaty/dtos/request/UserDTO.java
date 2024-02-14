package com.example.madrassaty.dtos.request;

import com.example.madrassaty.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDTO {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private StatusType status;
    private String city;
    private String address;

}
