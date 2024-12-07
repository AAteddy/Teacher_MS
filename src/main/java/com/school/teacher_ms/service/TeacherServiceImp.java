package com.school.teacher_ms.service;


import com.school.teacher_ms.dto.TeacherDTO;
import com.school.teacher_ms.exception.ValidationException;
import com.school.teacher_ms.mapper.MyMapper;
import com.school.teacher_ms.model.Teacher;
import com.school.teacher_ms.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService {


    private final TeacherRepo teacherRepo;
    private final MyMapper mapper;

    @Override
    public Teacher save(Teacher teacher) {
        if(teacher.getName() == null || teacher.getTitle() == null || teacher.getGender() == null)
            throw new ValidationException("Name or Title or Gender could not be null");

        return teacherRepo.save(teacher);
    }

    @Override
    public TeacherDTO getById(long id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ValidationException(
                        "Teacher with Id = " + id + " not found"));
        TeacherDTO teacherDTO = mapper.toTeacherDto(teacher);

        return teacherDTO;
    }

    @Override
    public List<TeacherDTO> getAll() {
        List<Teacher> teachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDtos = mapper.toTeacherListDto(teachers);

        return teacherDtos;
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

//    private TeacherDTO convertToDto(Teacher teacher) {
//        TeacherDTO teacherDTO = new TeacherDTO(
//                teacher.getId(),
//                teacher.getName(),
//                teacher.getGender(),
//                teacher.getTitle());
//
//        return teacherDTO;
//    }
}
