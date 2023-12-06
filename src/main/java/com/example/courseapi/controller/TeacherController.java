package com.example.courseapi.controller;

import com.example.courseapi.payload.request.PersonalRequest;
import com.example.courseapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<Object> AddTeacher(@RequestBody PersonalRequest personalRequest)
    {
        return teacherService.AddTeacher(personalRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllTeacher()
    {
        return teacherService.GetAllTeacher();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetTeacherById(@PathVariable long id) {
        return teacherService.GetTeacherById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteTeacherById(@PathVariable long id) {
        return teacherService.DeleteTeacherById(id);
    }

    @PostMapping("/edit-id/{id}")
    public ResponseEntity<Object> EditTeacherById(@RequestBody PersonalRequest personalRequest, @PathVariable long id) {
        return teacherService.EditTeacherById(personalRequest, id);
    }
}
