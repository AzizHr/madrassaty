package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassResponse {

    private UUID id;
    private String name;
    private SchoolDTO school;
    private List<ProfileResponse> students;

}
