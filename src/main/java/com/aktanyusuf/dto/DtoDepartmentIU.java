package com.aktanyusuf.dto;

import com.aktanyusuf.model.Course;
import com.aktanyusuf.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoDepartmentIU {

    private String name;
    private List<Course> courses;
    private List<Teacher> teachers;

}
