package com.example.madrassaty.dtos.request;

import com.example.madrassaty.enums.SchoolType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {

    private long id;
    private String name;
    private SchoolType type;

}
