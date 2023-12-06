package com.example.courseapi.controller;

import com.example.courseapi.payload.request.GradeRequest;
import com.example.courseapi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @PostMapping("/add")
    public ResponseEntity<Object> AddGrade(@RequestBody GradeRequest gradeRequest) {
        return gradeService.AddGrade(gradeRequest);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> GetAllGrade() {
        return gradeService.GetAllGrade();
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity<Object> GetGradeById(@PathVariable long id) {
        return gradeService.GetGradeById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Object> DeleteGradeById(@PathVariable long id) {
        return gradeService.DeleteGradeById(id);
    }

    @PostMapping("/edit-id/{id}")
    public ResponseEntity<Object> EditGradeById(@RequestBody GradeRequest gradeRequest, @PathVariable long id) {
        return gradeService.EditGradeById(gradeRequest, id);
    }
}
