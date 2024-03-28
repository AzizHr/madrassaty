package com.example.madrassaty.models;

import com.example.madrassaty.enums.SchoolType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private SchoolType type;
    @OneToMany(mappedBy = "school")
    private List<Year> years;
    @OneToMany(mappedBy = "school")
    private List<Specialty> specialties;
    @OneToMany(mappedBy = "school")
    private List<Manager> managers;
    @OneToMany(mappedBy = "school")
    private List<Class> classes;
    @OneToMany(mappedBy = "school")
    private List<Subject> subjects;

}
