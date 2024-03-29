package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse extends UserResponse {
    private SubjectDTO subject;
}
