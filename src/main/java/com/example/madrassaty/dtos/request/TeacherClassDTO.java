package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherClassDTO {
    @NotNull(message = "teacherId is required")
    private UUID teacherId;
    @NotNull(message = "classId is required")
    private UUID classId;
}
