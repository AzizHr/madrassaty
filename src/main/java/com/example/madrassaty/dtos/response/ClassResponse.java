package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassResponse {

    private long id;
    private String name;
    private SchoolDTO school;
    private List<UserResponse> students;

}
