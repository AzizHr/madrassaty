package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.enums.SchoolType;
import com.example.madrassaty.models.Manager;
import com.example.madrassaty.models.Specialty;
import com.example.madrassaty.models.Year;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolResponse {

    private long id;
    private String name;
    private SchoolType type;
    private List<YearDTO> years;
    private List<SpecialtyDTO> specialties;
    private List<UserResponse> managers;

}
