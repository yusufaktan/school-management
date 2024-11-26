package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoDepartment;
import com.aktanyusuf.dto.DtoDepartmentIU;
import com.aktanyusuf.model.Department;
import com.aktanyusuf.repository.DepartmentRepository;
import com.aktanyusuf.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DtoDepartment> add(DtoDepartmentIU dto) {
        Department department = new Department();
        BeanUtils.copyProperties(dto, department);
        departmentRepository.save(department);
        return getAll();
    }

    @Override
    public List<DtoDepartment> getAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DtoDepartment> dtoDepartments = new ArrayList<>();
        for (Department department : departments){
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(department, dtoDepartment);
            dtoDepartments.add(dtoDepartment);
        }
        return dtoDepartments;
    }

    @Override
    public DtoDepartment update(UUID id, DtoDepartmentIU object) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()){
            Department department = optional.get();
            BeanUtils.copyProperties(object, department);
            departmentRepository.save(department);
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(department, dtoDepartment);
            return dtoDepartment;
        }
        return null;
    }

    @Override
    public List<DtoDepartment> delete(UUID id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()){
            departmentRepository.delete(optional.get());
            return getAll();
        }
        return null;
    }

    @Override
    public DtoDepartment getById(UUID id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()){
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(optional.get(), dtoDepartment);
            return dtoDepartment;
        }
        return null;
    }
}
