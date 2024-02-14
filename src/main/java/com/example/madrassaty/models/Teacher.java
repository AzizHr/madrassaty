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
public class Teacher extends User {

    @ManyToOne
    private Subject subject;
    @ManyToMany
    private List<Class> classes;
}
