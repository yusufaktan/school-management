package com.aktanyusuf.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBaseProfileIU {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String gender;
    @NotNull
    private String address;
    @NotNull
    private String phoneNumber;
    @NotNull
    @Email
    private String email;
}
