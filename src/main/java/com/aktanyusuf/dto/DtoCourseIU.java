package com.aktanyusuf.dto;

import com.aktanyusuf.model.Classroom;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.model.Student;
import com.aktanyusuf.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourseIU {

    private String name;
    private Integer credits;
    private Department department;
    private Classroom classroom;
    private List<Student> students;
    private List<Teacher> teachers;

}
