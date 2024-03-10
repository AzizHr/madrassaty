package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherClassDTO {
    @NotNull(message = "teacherId is required")
    private long teacherId;
    @NotNull(message = "classId is required")
    private long classId;
}
