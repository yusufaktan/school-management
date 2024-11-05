package com.aktanyusuf.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoBaseProfile {

    private UUID id;
    private String name;
    private String surname;
    private String email;

}
