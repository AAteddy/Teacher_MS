package com.school.teacher_ms.service;


import com.school.teacher_ms.dto.RequestTeacherDTO;
import com.school.teacher_ms.dto.ResponseTeacherDTO;
import com.school.teacher_ms.exception.ValidationException;
import com.school.teacher_ms.mapper.MyMapper;
import com.school.teacher_ms.model.Teacher;
import com.school.teacher_ms.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
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
    public ResponseTeacherDTO save(RequestTeacherDTO requestTeacherDTO) {
        Teacher teacher = mapper.requestToTeacher(requestTeacherDTO);
        if(teacher.getName() == null ||
                teacher.getTitle() == null ||
                teacher.getGender() == null ||
                teacher.getEmail() == null)
            throw new ValidationException("Name or Title or Gender or Email could not be null");

        return mapper.toTeacherDto(teacherRepo.save(teacher));
    }

    @Override
    public ResponseTeacherDTO getById(long id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ValidationException(
                        "Teacher with Id = " + id + " not found"));

        return mapper.toTeacherDto(teacher);
    }

    @Override
    public List<ResponseTeacherDTO> getAll() {
        List<Teacher> teachers = teacherRepo.findAll();
        List<ResponseTeacherDTO> responseTeacherDtos = mapper.toTeacherListDto(teachers);

        return responseTeacherDtos;
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
