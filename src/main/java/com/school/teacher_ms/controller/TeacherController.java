package com.school.teacher_ms.controller;


import com.school.teacher_ms.dto.RequestTeacherDTO;
import com.school.teacher_ms.dto.ResponseTeacherDTO;
import com.school.teacher_ms.model.Teacher;
import com.school.teacher_ms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/school/teacher")
public class TeacherController {


    @Autowired
    TeacherService teacherService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World Teacher!";
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseTeacherDTO> create(@RequestBody RequestTeacherDTO requestTeacherDTO) {
        return new ResponseEntity<>(teacherService.save(requestTeacherDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTeacherDTO> getTeacherById(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseTeacherDTO>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTeacherById(@PathVariable long id) {
        teacherService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
        public ResponseEntity<Teacher> updateTeacher(@PathVariable long id, @RequestBody Teacher teacher) {
            Teacher updatedTeacher = teacherService.updateById(id, teacher);
            return ResponseEntity.ok(updatedTeacher);
        }

}
