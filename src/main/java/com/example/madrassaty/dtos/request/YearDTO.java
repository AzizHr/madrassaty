package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotEmpty;
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
public class YearDTO {

    private UUID id;
    @NotEmpty(message = "year can't be empty")
    @NotNull(message = "year is required")
    private String year;
    @NotNull(message = "schoolId is required")
    private UUID schoolId;

}
