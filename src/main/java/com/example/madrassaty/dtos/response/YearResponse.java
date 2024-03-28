package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class YearResponse {

    private UUID id;
    private String year;
    private SchoolDTO school;

}
