package com.aktanyusuf.dto;

import com.aktanyusuf.model.Course;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoClassroomIU {

    @NotNull
    private Integer roomNumber;
    @NotNull
    @Max(50)
    private Integer capacity;
    private List<Course> courses;

}
