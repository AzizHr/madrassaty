package com.example.madrassaty.dtos.request;

import com.example.madrassaty.enums.DurationType;
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
public class AbsenceDTO {

    private UUID id;
    @NotNull(message = "duration is required")
    private int duration;
    private DurationType durationType;
    @NotEmpty(message = "reason can't be empty")
    @NotNull(message = "reason is required")
    private String reason;
    @NotNull(message = "isJustified is required")
    private boolean isJustified;
    @NotNull(message = "studentId is required")
    private UUID studentId;

}
