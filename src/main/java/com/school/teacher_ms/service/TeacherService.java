package com.school.teacher_ms.service;


import com.school.teacher_ms.dto.RequestTeacherDTO;
import com.school.teacher_ms.dto.ResponseTeacherDTO;
import com.school.teacher_ms.model.Teacher;

import java.util.List;


public interface TeacherService {

    ResponseTeacherDTO save(RequestTeacherDTO requestTeacherDTO);

    ResponseTeacherDTO getById(long id);

    List<ResponseTeacherDTO> getAll();

    void removeById(long id);

    Teacher updateById(long id, Teacher teacher);
}
