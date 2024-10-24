package com.aktanyusuf.dto;

import com.aktanyusuf.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoClassroomIU {

    private Integer roomNumber;
    private Integer capacity;
    private List<Course> courses;

}
