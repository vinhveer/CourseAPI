package com.example.courseapi.service;

import com.example.courseapi.payload.request.PersonalRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    ResponseEntity<Object> AddStudent(PersonalRequest personalRequest);

    ResponseEntity<Object> GetAllStudent();

    ResponseEntity<Object> GetStudentById(long id);

    ResponseEntity<Object> DeleteStudentById(long id);

    ResponseEntity<Object> EditStudentById(PersonalRequest personalRequest, long id);
}
