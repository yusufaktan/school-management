package com.aktanyusuf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoClassroomInfo {
    private UUID id;
    private Integer roomNumber;
    private Integer capacity;
}
