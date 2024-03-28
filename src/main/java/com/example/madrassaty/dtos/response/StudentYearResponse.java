package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.YearDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentYearResponse {

    private UUID id;
    private LocalDate startsAt;
    private LocalDate endsAt;
    private String scholarYear;
    private ProfileResponse student;
    private YearDTO year;
}
