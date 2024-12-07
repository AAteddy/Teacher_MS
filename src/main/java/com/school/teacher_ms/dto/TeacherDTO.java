package com.school.teacher_ms.dto;


import com.school.teacher_ms.model.Gender;
import com.school.teacher_ms.model.Title;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeacherDTO {

    private long id;

    private String name;

    private Gender gender;

    private Title title;

}
