package com.example.madrassaty.models;

import com.example.madrassaty.models.embeddables.TeacherClassId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherClass {
    @EmbeddedId
    private TeacherClassId id;
}
