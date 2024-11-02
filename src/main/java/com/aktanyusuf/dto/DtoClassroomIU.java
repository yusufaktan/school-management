package com.aktanyusuf.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoClassroomIU {

    @NotNull
    private Integer roomNumber;
    @NotNull
    @Max(50)
    private Integer capacity;

}
