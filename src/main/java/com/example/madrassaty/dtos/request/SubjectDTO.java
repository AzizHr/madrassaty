package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

    private long id;
    @NotEmpty(message = "name can't be empty")
    @NotNull(message = "name is required")
    private String name;
    private int schoolId;

}
