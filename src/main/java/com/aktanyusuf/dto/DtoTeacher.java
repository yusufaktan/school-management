package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.model.DepartmentRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTeacher {

    private DepartmentRole departmentRole;
    private BaseProfile teacherProfile;
    private Department department;

}
