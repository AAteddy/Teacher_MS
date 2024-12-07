package com.school.teacher_ms.mapper;


import com.school.teacher_ms.dto.TeacherDTO;
import com.school.teacher_ms.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MyMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "title", source = "title")
    TeacherDTO toTeacherDto(Teacher teacher);
}
