package com.school.teacher_ms.service;


import com.school.teacher_ms.dto.TeacherDTO;
import com.school.teacher_ms.model.Teacher;

import java.util.List;


public interface TeacherService {

    Teacher save(Teacher teacher);

    TeacherDTO getById(long id);

    List<TeacherDTO> getAll();

    void removeById(long id);

    Teacher updateById(long id, Teacher teacher);
}
