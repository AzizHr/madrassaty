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
public class Class {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "_class")
    private List<Student> students;
}
