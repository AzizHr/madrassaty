package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.request.StudentYearDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileResponse extends ProfileResponse {
    private SpecialtyDTO specialty;
    private ClassDTO _class;
    private List<AbsenceDTO> absences;
    private List<StudentYearDTO> years;
}
