package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    private double gpa;
    private BaseProfile studentProfile;
    private List<Course> courses;

}
