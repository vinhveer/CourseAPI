package com.example.courseapi.controller;

import com.example.courseapi.payload.request.PersonalRequest;
import com.example.courseapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Object> AddStudent(@RequestBody PersonalRequest personalRequest)
    {
        return studentService.AddStudent(personalRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllStudent()
    {
        return studentService.GetAllStudent();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetStudentById(@PathVariable long id) {
        return studentService.GetStudentById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteStudentById(@PathVariable long id) {
        return studentService.DeleteStudentById(id);
    }

    @PostMapping("/edit-id/{id}")
    public ResponseEntity<Object> EditStudentById(@RequestBody PersonalRequest personalRequest, @PathVariable long id) {
        return studentService.EditStudentById(personalRequest, id);
    }
}