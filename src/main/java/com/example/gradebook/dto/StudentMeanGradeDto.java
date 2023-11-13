package com.example.gradebook.dto;

import com.example.gradebook.entity.Student;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StudentMeanGradeDto extends StudentDto{
    private double meanGrade;

    public StudentMeanGradeDto(Student student) {
        super(student);
        this.meanGrade = student.getMeanGrade();
    }
}
