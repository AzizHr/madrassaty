package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {

    private UUID id;
    private String name;
    private SchoolDTO school;

}
