package com.example.courseapi.service.impl;

import com.example.courseapi.model.Subject;
import com.example.courseapi.payload.request.SubjectRequest;
import com.example.courseapi.repository.SubjectRepository;
import com.example.courseapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public ResponseEntity<Object> AddSubject(SubjectRequest subjectRequest) {
        Subject subject = Subject.builder()
                .subjectName(subjectRequest.getSubjectName())
                .credit(subjectRequest.getCredit()).build();

        subjectRepository.save(subject);

        return ResponseEntity.ok("Subject added sucessfully!");
    }

    @Override
    public ResponseEntity<Object> GetAllSubject() {
        List<Subject> subjectList = subjectRepository.findAll();
        return ResponseEntity.ok(subjectList);
    }

    @Override
    public ResponseEntity<Object> GetSubjectById(long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return ResponseEntity.ok().body(subject);
    }

    @Override
    public ResponseEntity<Object> DeleteSubjectById(long id) {
        subjectRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete subject sucessfully!");
    }

    @Override
    public ResponseEntity<Object> EditSubjectById(SubjectRequest subjectRequest, long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        Subject updateSubject = subject.get();
        updateSubject.setSubjectName(subjectRequest.getSubjectName());
        updateSubject.setCredit(subjectRequest.getCredit());

        subjectRepository.save(updateSubject);

        return ResponseEntity.ok("Subject updated sucessfully!");
    }
}
