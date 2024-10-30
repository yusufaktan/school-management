package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoClassroom;
import com.aktanyusuf.model.Classroom;
import com.aktanyusuf.repository.ClassroomRepository;
import com.aktanyusuf.service.IClassroomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;


    @Override
    public List add(Object object) {
        return List.of();
    }

    @Override
    public List<DtoClassroom> getAll() {
        List<Classroom> classrooms = classroomRepository.findAll();
        List<DtoClassroom> dtoClassrooms = new ArrayList<>();
        for (Classroom classroom : classrooms){
            DtoClassroom dtoClassroom = new DtoClassroom();
            BeanUtils.copyProperties(classroom, dtoClassroom);
            dtoClassrooms.add(dtoClassroom);
        }
        return dtoClassrooms;
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
