package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.ITeacherController;
import com.aktanyusuf.dto.DtoTeacher;
import com.aktanyusuf.dto.DtoTeacherIU;
import com.aktanyusuf.service.impl.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController implements ITeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    @Override
    public List<DtoTeacher> add(@RequestBody @Valid DtoTeacherIU dto) {
        return teacherService.add(dto);
    }

    @GetMapping
    @Override
    public List<DtoTeacher> getAll() {
        return teacherService.getAll();
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoTeacher update(@PathVariable(name = "id") UUID id, @RequestBody @Valid DtoTeacherIU object) {
        return teacherService.update(id, object);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public List<DtoTeacher> delete(@PathVariable(name = "id") UUID id) {
        return teacherService.delete(id);
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoTeacher getById(@PathVariable(name = "id") UUID id) {
        return teacherService.getById(id);
    }
}
