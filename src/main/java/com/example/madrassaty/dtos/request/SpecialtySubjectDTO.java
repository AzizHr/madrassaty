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
public class SpecialtySubjectDTO {
    @NotNull(message = "specialtyId is required")
    private UUID specialtyId;
    @NotNull(message = "subjectId is required")
    private UUID subjectId;
}
