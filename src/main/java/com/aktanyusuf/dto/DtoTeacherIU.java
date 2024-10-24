package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.model.Course;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.model.DepartmentRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTeacherIU {

    private DepartmentRole departmentRole;
    private BaseProfile teacherProfile;
    private List<Course> courses;
    private Department department;

}
