package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.enums.SchoolType;
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
public class SchoolResponse {

    private UUID id;
    private String name;
    private SchoolType type;
    private List<YearDTO> years;
    private List<SpecialtyDTO> specialties;
    private List<SubjectDTO> subjects;
    private List<ProfileResponse> managers;

}
