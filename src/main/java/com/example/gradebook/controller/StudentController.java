package com.example.gradebook.controller;

import com.example.gradebook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PutMapping("/{studentId}/marks/{subjectName}/{mark}")
    public ResponseEntity<?> updateStudentGrade(@PathVariable("studentId") int studentId,
                                                @PathVariable("subjectName") String subjectName,
                                                @PathVariable("mark") int mark) {

        return ResponseEntity.ok(studentService.updateGradeByStudentId(studentId, subjectName, mark));
    }
}
