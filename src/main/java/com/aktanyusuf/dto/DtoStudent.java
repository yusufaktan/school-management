package com.aktanyusuf.dto;

import com.aktanyusuf.model.BaseProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {

    private UUID id;
    private double gpa;
    private BaseProfile studentProfile;

}
