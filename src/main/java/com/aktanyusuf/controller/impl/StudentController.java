package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IStudentController;
import com.aktanyusuf.dto.DtoStudent;
import com.aktanyusuf.dto.DtoStudentIU;
import com.aktanyusuf.service.impl.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController implements IStudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @Override
    public List<DtoStudent> add(@RequestBody @Valid DtoStudentIU dto) {
        return studentService.add(dto);
    }

    @GetMapping
    @Override
    public List<DtoStudent> getAll() {
        return studentService.getAll();
    }

    @Override
    public DtoStudent update(UUID id, DtoStudentIU object) {
        return null;
    }

    @Override
    public List<DtoStudent> delete(UUID id) {
        return List.of();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoStudent getById(@PathVariable(name = "id") UUID id) {
        return studentService.getById(id);
    }
}
