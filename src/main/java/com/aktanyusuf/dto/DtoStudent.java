package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {

    private double gpa;
    private BaseProfile studentProfile;

}
