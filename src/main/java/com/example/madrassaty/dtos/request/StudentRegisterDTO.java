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
public class StudentRegisterDTO extends UserDTO {

    @NotNull(message = "specialtyId is required")
    private long specialtyId;
    @NotNull(message = "classId is required")
    private long classId;
}
