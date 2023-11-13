package com.example.gradebook.dto;

import com.example.gradebook.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradesDto extends StudentDto {
    private Set<GradeDto> grades;

    public StudentGradesDto(Student student) {
        super(student);
        grades = new HashSet<>();
        for (var grade : student.getGrades())
            grades.add(new GradeDto(grade));
    }

}
