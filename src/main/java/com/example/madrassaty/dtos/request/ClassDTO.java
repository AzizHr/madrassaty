package com.example.madrassaty.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {

    private long id;
    @NotEmpty(message = "name can't be empty")
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "schoolId is required")
    private long schoolId;

}
