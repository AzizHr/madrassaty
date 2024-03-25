package com.example.madrassaty.dtos.response;

import com.example.madrassaty.enums.StatusType;
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
    private String image;
    private StatusType status;
    private String city;
    private String address;
}
