package com.example.madrassaty.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentYearDTO {

    private long id;
    private LocalDate startsAt;
    private LocalDate endsAt;
    private String scholarYear;
    private long studentId;
    private long yearId;
}
