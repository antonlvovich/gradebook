package com.example.gradebook.service;

import com.example.gradebook.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    StudentDto getStudent(String name, String surname, int groupId);
    List<StudentDto> getStudentMeanGradeByGroup(int groupId);
    void updateStudentGrade();
    void addStudent(StudentDto student);
}
