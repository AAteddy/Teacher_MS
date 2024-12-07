package com.school.teacher_ms.mapper;


import com.school.teacher_ms.dto.TeacherDTO;
import com.school.teacher_ms.model.Teacher;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MyMapper {
    TeacherDTO toTeacherDto(Teacher teacher);
}
