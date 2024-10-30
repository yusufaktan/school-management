package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IClassroomController;
import com.aktanyusuf.dto.DtoClassroom;
import com.aktanyusuf.service.impl.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController implements IClassroomController {

    @Autowired
    ClassroomService classroomService;

    @Override
    public List add(Object object) {
        return List.of();
    }

    @GetMapping
    @Override
    public List<DtoClassroom> getAll() {
        return classroomService.getAll();
    }

    @Override
    public Object update(UUID id, Object object) {
        return null;
    }

    @Override
    public List delete(UUID id) {
        return List.of();
    }

    @Override
    public Object getById(UUID id) {
        return null;
    }
}
