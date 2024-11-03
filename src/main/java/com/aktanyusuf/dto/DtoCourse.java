package com.aktanyusuf.dto;

import com.aktanyusuf.model.Classroom;
import com.aktanyusuf.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourse {

    private UUID id;
    private String name;
    private Integer credits;
    private Department department;
    private Classroom classroom;

}
