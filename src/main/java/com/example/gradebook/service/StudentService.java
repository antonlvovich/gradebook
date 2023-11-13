package com.example.gradebook.service;

import com.example.gradebook.access.GradeRepo;
import com.example.gradebook.access.StudentRepo;
import com.example.gradebook.dto.GroupDto;
import com.example.gradebook.dto.StudentDto;
import com.example.gradebook.dto.StudentGradesDto;
import com.example.gradebook.dto.StudentMeanGradeDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private GradeRepo gradeRepo;

    public GroupDto<StudentDto> getGroup(int groupId) {
        List<StudentDto> students = new ArrayList<>();
        for (var x : studentRepo.findByGroupId(groupId)) {
            students.add(new StudentDto(x));
        }
        return new GroupDto<>(students, students.size());
    }

    public GroupDto<StudentMeanGradeDto> getMeanGradeGroup(int groupId) {
        List<StudentMeanGradeDto> students = new ArrayList<>();
        for (var x : studentRepo.findByGroupId(groupId)) {
            students.add(new StudentMeanGradeDto(x));
        }
        return new GroupDto<>(students, students.size());
    }

    public StudentGradesDto updateGradeByStudentId(int studentId, String subjectName, int mark) {
        gradeRepo.updateMarkByStudentId(mark, subjectName, studentId);
        var student = studentRepo.getReferenceById(studentId);
        return new StudentGradesDto(student);
    }

    public GroupDto<StudentMeanGradeDto> updateGradeByStudentNameSurname(int groupId, String name, String surname, String subjectName, int mark) {
        List<Integer> studentIds = studentRepo.getStudentsIdByGroupNameSurname(groupId, name, surname);
        if (studentIds == null)
            return null;
        List<StudentMeanGradeDto> students = new ArrayList<>();
        for (var studentId : studentIds) {
            gradeRepo.updateMarkByStudentId(mark, subjectName, studentId);
            students.add(new StudentMeanGradeDto(studentRepo.getReferenceById(studentId)));
        }
        return new GroupDto<>(students, students.size());
    }
}
