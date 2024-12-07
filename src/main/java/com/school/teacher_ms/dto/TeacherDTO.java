package com.school.teacher_ms.dto;


import com.school.teacher_ms.model.Gender;
import com.school.teacher_ms.model.Title;


public record TeacherDTO(long id, String name, Gender gender, Title title) {
}
