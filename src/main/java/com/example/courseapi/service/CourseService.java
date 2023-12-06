package com.example.courseapi.service;

import com.example.courseapi.payload.request.CourseRequest;
import com.example.courseapi.payload.request.PersonalRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    ResponseEntity<Object> AddCourse(CourseRequest courseRequest);

    ResponseEntity<Object> GetAllCourse();

    ResponseEntity<Object> GetCourseById(long id);

    ResponseEntity<Object> DeleteCourseById(long id);

    ResponseEntity<Object> EditCourseById(CourseRequest courseRequest, long id);
}
