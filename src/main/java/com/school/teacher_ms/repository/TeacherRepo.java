package com.school.teacher_ms.repository;


import com.school.teacher_ms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
