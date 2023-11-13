package com.example.gradebook.dto;

import com.example.gradebook.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradesDto extends StudentDto {
    private Map<String, Short> grades;

    public StudentGradesDto(Student student) {
        super(student);
        grades = new HashMap<>();
        for (var grade : student.getGrades()) {
            grades.put(grade.getId().getSubjectName(), grade.getMark());
        }
    }
}
