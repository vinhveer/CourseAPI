package com.example.courseapi.controller;

import com.example.courseapi.payload.request.SubjectRequest;
import com.example.courseapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController
{
    @Autowired
    SubjectService subjectService;

    @PostMapping("/add")
    public ResponseEntity<Object> AddSubject(@RequestBody SubjectRequest subjectRequest)
    {
        return subjectService.AddSubject(subjectRequest) ;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllSubject()
    {
        return subjectService.GetAllSubject();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetSubjectById(@PathVariable long id)
    {
        return subjectService.GetSubjectById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteSubjectById(@PathVariable long id)
    {
        return subjectService.DeleteSubjectById(id);
    }

    @PostMapping("/edit-id/{id}")
    public ResponseEntity<Object> EditSubjectById(@PathVariable long id, @RequestBody SubjectRequest subjectRequest)
    {
        return subjectService.EditSubjectById(subjectRequest, id);
    }
}
