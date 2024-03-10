package com.example.madrassaty.dtos.response;

import com.example.madrassaty.enums.DurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceResponse {

    private long id;
    private LocalDate date;
    private int duration;
    private DurationType durationType;
    private String reason;
    private boolean isJustified;
    private UserResponse student;

}
