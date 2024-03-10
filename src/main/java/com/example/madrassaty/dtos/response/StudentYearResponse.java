package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.YearDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentYearResponse {

    private long id;
    private LocalDate startsAt;
    private LocalDate endsAt;
    private String scholarYear;
    private UserResponse student;
    private YearDTO year;
}
