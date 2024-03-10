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
public class SpecialtySubjectDTO {
    @NotNull(message = "specialtyId is required")
    private long specialtyId;
    @NotNull(message = "subjectId is required")
    private long subjectId;
}
