package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotNull
    @Size(max = 4)
    private double gpa;

    @NotNull
    private BaseProfile studentProfile;


}
