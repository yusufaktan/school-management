package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.*;
import com.aktanyusuf.model.Course;
import com.aktanyusuf.repository.CourseRepository;
import com.aktanyusuf.service.ICourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<DtoCourse> add(DtoCourseIU dto) {
        Course course = new Course();
        BeanUtils.copyProperties(dto, course);
        courseRepository.save(course);
        return getAll();
    }

    @Override
    public List<DtoCourse> getAll() {
        List<DtoCourse> dtoCourses = new ArrayList<>();
        List<Course> courses = courseRepository.findAll();
        for (Course course : courses){
            DtoCourse dtoCourse = new DtoCourse();
            BeanUtils.copyProperties(course, dtoCourse);
            if (course.getClassroom() != null){
                DtoClassroomInfo dtoClassroomInfo = new DtoClassroomInfo();
                BeanUtils.copyProperties(course.getClassroom(), dtoClassroomInfo);
                dtoCourse.setClassroom(dtoClassroomInfo);
            }
            if (course.getDepartment() != null){
                DtoDepartment dtoDepartment = new DtoDepartment();
                BeanUtils.copyProperties(course.getDepartment(), dtoDepartment);
                dtoCourse.setDepartment(dtoDepartment);
            }
            dtoCourses.add(dtoCourse);
        }
        return dtoCourses;
    }

    @Override
    public DtoCourse update(UUID id, DtoCourseIU object) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            Course course = new Course();
            BeanUtils.copyProperties(object, course);
            courseRepository.save(course);
            DtoCourse dtoCourse = new DtoCourse();
            BeanUtils.copyProperties(course, dtoCourse);
            return dtoCourse;
        }
        return null;
    }

    @Override
    public List<DtoCourse> delete(UUID id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            courseRepository.delete(optional.get());
            return getAll();
        }
        return null;
    }

    @Override
    public DtoCourse getById(UUID id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            DtoCourse dtoCourse = new DtoCourse();
            BeanUtils.copyProperties(optional.get(), dtoCourse);
            return dtoCourse;
        }
        return null;
    }
}
