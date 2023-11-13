package com.example.gradebook.controller;

import com.example.gradebook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroup(@PathVariable("id") int groupId){
        return ResponseEntity.ok(studentService.getGroup(groupId));
    }

    @GetMapping("/{id}/avg_marks")
    public ResponseEntity<?> getMeanGradeByGroup(@PathVariable("id") int groupId){
        return ResponseEntity.ok(studentService.getMeanGradeGroup(groupId));
    }

    @PutMapping("{groupId}/students/{name}/{surname}/marks/{subjectName}/{mark}")
    public ResponseEntity<?> updateStudentGrade(@PathVariable("groupId") int groupId,
                                                @PathVariable("name") String name,
                                                @PathVariable("surname") String surname,
                                                @PathVariable("subjectName") String subjectName,
                                                @PathVariable("mark") int mark) {

        return ResponseEntity.ok(studentService.updateGradeByStudentNameSurname(groupId, name, surname, subjectName, mark));
    }
}
