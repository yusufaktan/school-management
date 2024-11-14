package com.aktanyusuf.dto;

import com.aktanyusuf.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoClassroom {

    private UUID id;
    private Integer roomNumber;
    private Integer capacity;
    private List<DtoCourse> courses;

}
