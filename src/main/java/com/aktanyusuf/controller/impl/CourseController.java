package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.ICourseController;
import com.aktanyusuf.dto.DtoCourse;
import com.aktanyusuf.dto.DtoCourseIU;
import com.aktanyusuf.service.impl.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/course")
public class CourseController implements ICourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    @Override
    public List<DtoCourse> add(@RequestBody @Valid DtoCourseIU dto) {
        return courseService.add(dto);
    }

    @GetMapping
    @Override
    public List<DtoCourse> getAll() {
        return courseService.getAll();
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoCourse update(@PathVariable(name = "id") UUID id, @RequestBody @Valid DtoCourseIU object) {
        return courseService.update(id, object);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public List<DtoCourse> delete(@PathVariable(name = "id") UUID id) {
        return courseService.delete(id);
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoCourse getById(@PathVariable(name = "id") UUID id) {
        return courseService.getById(id);
    }
}
