package com.aktanyusuf.dto;

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
    private DtoClassroomInfo classroom;
    private DtoDepartment department;


}
