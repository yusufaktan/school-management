package com.aktanyusuf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classroom")
@Entity
public class Classroom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Course> courses;

}
