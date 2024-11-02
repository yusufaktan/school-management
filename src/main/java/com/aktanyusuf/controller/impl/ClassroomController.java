package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IClassroomController;
import com.aktanyusuf.dto.DtoClassroom;
import com.aktanyusuf.dto.DtoClassroomIU;
import com.aktanyusuf.service.impl.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController implements IClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping
    @Override
    public List<DtoClassroom> add(@RequestBody @Valid DtoClassroomIU dtoClassroomIU) {
        return classroomService.add(dtoClassroomIU);
    }

    @GetMapping
    @Override
    public List<DtoClassroom> getAll() {
        return classroomService.getAll();
    }

    @Override
    public DtoClassroom update(UUID id, DtoClassroom object) {
        return null;
    }

    @Override
    public List<DtoClassroom> delete(UUID id) {
        return List.of();
    }

    @Override
    public DtoClassroom getById(UUID id) {
        return null;
    }

}
