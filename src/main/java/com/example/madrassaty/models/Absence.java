package com.example.madrassaty.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Absence {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;
    private String duration;
    private String reason;
    private boolean isJustified;
    @ManyToOne
    private Student student;

}
