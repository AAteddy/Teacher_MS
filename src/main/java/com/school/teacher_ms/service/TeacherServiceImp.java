package com.school.teacher_ms.service;


import com.school.teacher_ms.exception.ValidationException;
import com.school.teacher_ms.model.Teacher;
import com.school.teacher_ms.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher save(Teacher teacher) {
        if(teacher.getName() == null || teacher.getTitle() == null || teacher.getGender() == null)
            throw new ValidationException("Name or Title or Gender could not be null");

        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepo.findById(id)
                .orElseThrow(() -> new ValidationException(
                        "Teacher with Id = " + id + " not found"));

    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void removeById(long id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Teacher with Id = " + id + " not found"
                ));

        teacherRepo.delete(teacher);
    }

    @Override
    public Teacher updateById(long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Teacher with Id = " + " not found"
                ));
        existingTeacher.setName(teacher.getName());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setTitle(teacher.getTitle());

        return teacherRepo.save(existingTeacher);
    }
}