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
public class Specialty {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private School school;
    @OneToMany(mappedBy = "specialty")
    private List<Student> students;
    @ManyToMany
    private List<Subject> subjects;

}
