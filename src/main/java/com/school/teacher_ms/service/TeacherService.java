package com.school.teacher_ms.service;


import com.school.teacher_ms.model.Teacher;

import java.util.List;


public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher getById(long id);

    List<Teacher> getAll();

    void removeById(long id);

    Teacher updateById(long id, Teacher teacher);
}
