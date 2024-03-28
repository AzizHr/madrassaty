package com.example.madrassaty.models.embeddables;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SpecialtySubjectId implements Serializable {
    private UUID specialtyId;
    private UUID subjectId;
}
