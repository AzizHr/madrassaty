package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class StudentYearDTO {

    private UUID id;
    @NotNull(message = "startsAt is required")
    private LocalDate startsAt;
    @NotNull(message = "endsAt is required")
    private LocalDate endsAt;
    @NotEmpty(message = "scholarYear can't be empty")
    @NotNull(message = "scholarYear is required")
    private String scholarYear;
    @NotNull(message = "studentId is required")
    private UUID studentId;
    @NotNull(message = "yearId is required")
    private UUID yearId;
}
