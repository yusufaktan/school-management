package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IDepartmentController;
import com.aktanyusuf.dto.DtoDepartment;
import com.aktanyusuf.dto.DtoDepartmentIU;
import com.aktanyusuf.service.impl.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/department")
public class DepartmentController implements IDepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    @Override
    public List<DtoDepartment> add(@RequestBody @Valid DtoDepartmentIU dto) {
        return departmentService.add(dto);
    }

    @GetMapping
    @Override
    public List<DtoDepartment> getAll() {
        return departmentService.getAll();
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoDepartment update(@PathVariable(name = "id") UUID id, @RequestBody @Valid DtoDepartmentIU object) {
        return departmentService.update(id, object);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public List<DtoDepartment> delete(@PathVariable(name = "id") UUID id) {
        return departmentService.delete(id);
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoDepartment getById(@PathVariable(name = "id") UUID id) {
        return departmentService.getById(id);
    }
}
