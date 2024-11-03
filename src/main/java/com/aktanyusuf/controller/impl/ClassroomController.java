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

    @PutMapping(path = "/{id}")
    @Override
    public DtoClassroom update(@PathVariable(name = "id") UUID id, @RequestBody @Valid DtoClassroomIU object) {
        return classroomService.update(id, object);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public List<DtoClassroom> delete(@PathVariable(name = "id") UUID id) {
        return classroomService.delete(id);
    }

    @Override
    public DtoClassroom getById(UUID id) {
        return null;
    }

}
