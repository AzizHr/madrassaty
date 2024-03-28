package com.example.madrassaty.models;

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
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String year;
    @ManyToOne
    private School school;
    @OneToMany(mappedBy = "year")
    private List<StudentYear> studentYears;

}
