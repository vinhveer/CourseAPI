package com.example.courseapi.service;

import com.example.courseapi.payload.request.GradeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface GradeService {
    ResponseEntity<Object> AddGrade(GradeRequest gradeRequest);

    ResponseEntity<Object> GetAllGrade();

    ResponseEntity<Object> GetGradeById(long id);

    ResponseEntity<Object> DeleteGradeById(long id);

    ResponseEntity<Object> EditGradeById(GradeRequest gradeRequest, long id);
}
