package com.example.courseapi.controller;

import com.example.courseapi.payload.request.CourseRequest;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Object> AddCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.AddCourse(courseRequest);
    }

    @GetMapping("/get-all")
    ResponseEntity<Object> GetAllCourse() {
        return courseService.GetAllCourse();
    }

    @GetMapping("/get-id/{id}")
    ResponseEntity<Object> GetCourseById(@PathVariable long id) {
        return courseService.GetCourseById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    ResponseEntity<Object> DeleteCourseById(@PathVariable long id) {
        return courseService.DeleteCourseById(id);
    }

    @PostMapping("/edit-id/{id}")
    ResponseEntity<Object> EditCourseById(@RequestBody CourseRequest courseRequest, @PathVariable long id) {
        return courseService.EditCourseById(courseRequest, id);
    }
}
