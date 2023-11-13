package com.example.gradebook.dto;

import com.example.gradebook.entity.Student;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    protected String name;

    protected String surname;

    protected int age;

    public StudentDto(Student student) {
        this.name = student.getFirstName();
        this.surname = student.getLastName();
        this.age = student.getAge();
    }
}
