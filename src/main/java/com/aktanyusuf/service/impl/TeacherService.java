package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoBaseProfile;
import com.aktanyusuf.dto.DtoDepartment;
import com.aktanyusuf.dto.DtoTeacher;
import com.aktanyusuf.dto.DtoTeacherIU;
import com.aktanyusuf.model.Teacher;
import com.aktanyusuf.repository.TeacherRepository;
import com.aktanyusuf.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<DtoTeacher> add(DtoTeacherIU dto) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(dto, teacher);
        teacherRepository.save(teacher);
        return getAll();
    }

    @Override
    public List<DtoTeacher> getAll() {
        List<DtoTeacher> dtoTeachers = new ArrayList<>();
        List<Teacher> teachers = teacherRepository.findAll();
        for (Teacher teacher : teachers){
            DtoTeacher dtoTeacher = new DtoTeacher();
            BeanUtils.copyProperties(teacher, dtoTeacher);
            if (teacher.getTeacherProfile() != null){
                DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
                BeanUtils.copyProperties(teacher.getTeacherProfile(), dtoBaseProfile);
                dtoTeacher.setTeacherProfile(dtoBaseProfile);
            }
            if (teacher.getDepartment() != null){
                DtoDepartment dtoDepartment = new DtoDepartment();
                BeanUtils.copyProperties(teacher.getDepartment(), dtoDepartment);
                dtoTeacher.setDepartment(dtoDepartment);
            }
            dtoTeachers.add(dtoTeacher);
        }
        return dtoTeachers;
    }

    @Override
    public DtoTeacher update(UUID id, DtoTeacherIU object) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        if (optional.isPresent()){
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(object, teacher);
            teacherRepository.save(teacher);
            DtoTeacher dtoTeacher = new DtoTeacher();
            BeanUtils.copyProperties(teacher, dtoTeacher);
            return dtoTeacher;
        }
        return null;
    }

    @Override
    public List<DtoTeacher> delete(UUID id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        if (optional.isPresent()){
            teacherRepository.delete(optional.get());
            return getAll();
        }
        return null;
    }

    @Override
    public DtoTeacher getById(UUID id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        if (optional.isPresent()){
            DtoTeacher dtoTeacher = new DtoTeacher();
            BeanUtils.copyProperties(optional.get(), dtoTeacher);
            DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
            BeanUtils.copyProperties(optional.get().getTeacherProfile(), dtoBaseProfile);
            dtoTeacher.setTeacherProfile(dtoBaseProfile);
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(optional.get().getDepartment(), dtoDepartment);
            dtoTeacher.setDepartment(dtoDepartment);
            return dtoTeacher;
        }
        return null;
    }
}
