package com.school.teacher_ms.mapper;


import com.school.teacher_ms.dto.RequestTeacherDTO;
import com.school.teacher_ms.dto.ResponseTeacherDTO;
import com.school.teacher_ms.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MyMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "title", source = "title")
    ResponseTeacherDTO toTeacherDto(Teacher teacher);

    List<ResponseTeacherDTO> toTeacherListDto(List<Teacher> teachers);

//    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "email", source = "email")
    Teacher requestToTeacher(RequestTeacherDTO requestTeacherDto);

}
