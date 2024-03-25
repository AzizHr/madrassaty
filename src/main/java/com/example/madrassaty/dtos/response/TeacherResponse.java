package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse extends User {
    private SubjectDTO subject;
}
