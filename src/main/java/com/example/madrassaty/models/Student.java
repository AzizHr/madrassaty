package com.example.madrassaty.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends User {

    @ManyToOne
    private Specialty specialty;
    @ManyToOne
    private Class _class;
    @OneToMany(mappedBy = "student")
    private List<Absence> absences;
    @OneToMany(mappedBy = "student")
    private List<StudentYear> studentYears;

}
