package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.model.DepartmentRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoTeacher {

    private UUID id;
    private DepartmentRole departmentRole;
    private BaseProfile teacherProfile;
    private Department department;

}
