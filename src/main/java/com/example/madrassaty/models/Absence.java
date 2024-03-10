package com.example.madrassaty.models;

import com.example.madrassaty.enums.DurationType;
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
    private int duration;
    @Enumerated(EnumType.STRING)
    private DurationType durationType;
    private String reason;
    private boolean isJustified;
    @ManyToOne
    private Student student;

}
