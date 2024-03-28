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
public class StudentRegisterDTO extends UserDTO {

    @NotNull(message = "specialtyId is required")
    private UUID specialtyId;
    @NotNull(message = "classId is required")
    private UUID classId;
}
