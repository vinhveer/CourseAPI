package com.example.courseapi.service;

import com.example.courseapi.payload.request.SubjectRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    ResponseEntity<Object> AddSubject(SubjectRequest subjectRequest);

    ResponseEntity<Object> GetAllSubject();

    ResponseEntity<Object> GetSubjectById(long id);

    ResponseEntity<Object> DeleteSubjectById(long id);

    ResponseEntity<Object> EditSubjectById(SubjectRequest subjectRequest, long id);
}
