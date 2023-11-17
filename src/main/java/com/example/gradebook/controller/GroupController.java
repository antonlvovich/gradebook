package com.example.gradebook.controller;

import com.example.gradebook.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final StudentService studentService;

    public GroupController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getGroup(@PathVariable("groupId") int groupId){
        return ResponseEntity.ok(studentService.getGroup(groupId));
    }

    @GetMapping("/{groupId}/avg_marks")
    public ResponseEntity<?> getMeanGradeByGroup(@PathVariable("groupId") int groupId){
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
