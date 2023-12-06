package com.example.courseapi.service;

import com.example.courseapi.payload.request.PersonalRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherService {
    ResponseEntity<Object> AddTeacher(PersonalRequest personalRequest);

    ResponseEntity<Object> GetAllTeacher();

    ResponseEntity<Object> GetTeacherById(long id);

    ResponseEntity<Object> DeleteTeacherById(long id);

    ResponseEntity<Object> EditTeacherById(PersonalRequest personalRequest, long id);
}
