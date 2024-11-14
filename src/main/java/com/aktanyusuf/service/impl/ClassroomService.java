package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoClassroom;
import com.aktanyusuf.dto.DtoClassroomIU;
import com.aktanyusuf.dto.DtoCourse;
import com.aktanyusuf.dto.DtoDepartment;
import com.aktanyusuf.model.Classroom;
import com.aktanyusuf.model.Course;
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
    public List<DtoClassroom> add(DtoClassroomIU dtoClassroomIU) {
        Classroom classroom = new Classroom();
        BeanUtils.copyProperties(dtoClassroomIU, classroom);
        classroomRepository.save(classroom);
        return getAll();
    }

    @Override
    public List<DtoClassroom> getAll() {
        List<Classroom> classrooms = classroomRepository.findAll();
        List<DtoClassroom> dtoClassrooms = new ArrayList<>();
        for (Classroom classroom : classrooms){
            DtoClassroom dtoClassroom = new DtoClassroom();
            List<DtoCourse> dtoCourses = new ArrayList<>();
            if (classroom.getCourses() != null && !classroom.getCourses().isEmpty()){
                for (Course course : classroom.getCourses()){
                    DtoDepartment dtoDepartment = new DtoDepartment();
                    DtoCourse dtoCourse = new DtoCourse();
                    BeanUtils.copyProperties(course.getDepartment(), dtoDepartment);
                    BeanUtils.copyProperties(course, dtoCourse);
                    dtoCourse.setDepartment(dtoDepartment);
                    dtoCourses.add(dtoCourse);
                }
            }
            dtoClassroom.setCourses(dtoCourses);
            BeanUtils.copyProperties(classroom, dtoClassroom);
            dtoClassrooms.add(dtoClassroom);
        }
        return dtoClassrooms;
    }

    @Override
    public DtoClassroom update(UUID id, DtoClassroomIU object) {
        for (Classroom classroom : classroomRepository.findAll()){
            if (classroom.getId().equals(id)){
                BeanUtils.copyProperties(object, classroom);
                classroomRepository.save(classroom);
                DtoClassroom dtoClassroom = new DtoClassroom();
                BeanUtils.copyProperties(classroom, dtoClassroom);
                return dtoClassroom;
            }
        }
        return null;
    }

    @Override
    public List<DtoClassroom> delete(UUID id) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom : classrooms){
            if (id.equals(classroom.getId())){
                classroomRepository.delete(classroom);
                return getAll();
            }
        }
        return null;
    }

    @Override
    public DtoClassroom getById(UUID id) {
        List<Classroom> classrooms = classroomRepository.findAll();
        for (Classroom classroom : classrooms){
            if (id.equals(classroom.getId())){
                DtoClassroom dtoClassroom = new DtoClassroom();
                BeanUtils.copyProperties(classroom, dtoClassroom);
                return dtoClassroom;

            }
        }
        return null;
    }

}
