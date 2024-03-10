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
public class StudentYear {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate startsAt;
    private LocalDate endsAt;
    private String scholarYear;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Year year;

}
