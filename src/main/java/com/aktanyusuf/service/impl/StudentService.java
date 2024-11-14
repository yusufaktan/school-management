package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoBaseProfile;
import com.aktanyusuf.dto.DtoStudent;
import com.aktanyusuf.dto.DtoStudentIU;
import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.model.Student;
import com.aktanyusuf.repository.StudentRepository;
import com.aktanyusuf.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<DtoStudent> add(DtoStudentIU dto) {
        Student student = new Student();
        BeanUtils.copyProperties(dto, student);
        studentRepository.save(student);
        return getAll();
    }

    @Override
    public List<DtoStudent> getAll() {
        List<Student> students = studentRepository.findAll();
        List<DtoStudent> dtoStudents = new ArrayList<>();
        for (Student student : students){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            DtoBaseProfile baseProfile = new DtoBaseProfile();
            BeanUtils.copyProperties(student.getStudentProfile(), baseProfile);
            dtoStudent.setStudentProfile(baseProfile);
            dtoStudents.add(dtoStudent);
        }
        return dtoStudents;
    }

    @Override
    public DtoStudent update(UUID id, DtoStudentIU object) {
        return null;
    }

    @Override
    public List<DtoStudent> delete(UUID id) {
        return List.of();
    }

    @Override
    public DtoStudent getById(UUID id) {
        DtoStudent dtoStudent = new DtoStudent();
        DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        Student student = optional.get();
        BaseProfile baseProfile = optional.get().getStudentProfile();
        BeanUtils.copyProperties(student, dtoStudent);
        BeanUtils.copyProperties(baseProfile, dtoBaseProfile);
        dtoStudent.setStudentProfile(dtoBaseProfile);
        return dtoStudent;
    }
}
