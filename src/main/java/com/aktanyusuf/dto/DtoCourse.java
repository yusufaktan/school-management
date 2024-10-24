package com.aktanyusuf.dto;

import com.aktanyusuf.model.Classroom;
import com.aktanyusuf.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourse {

    private String name;
    private Integer credits;
    private Department department;
    private Classroom classroom;

}
