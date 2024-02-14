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
public class AbsenceDTO {

    private long id;
    private LocalDate date;
    private String duration;
    private String reason;
    private boolean isJustified;
    private long studentId;

}
