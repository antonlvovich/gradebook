package com.example.gradebook.service;

import com.example.gradebook.access.GradeRepo;
import com.example.gradebook.access.StudentRepo;
import com.example.gradebook.dto.GroupDto;
import com.example.gradebook.dto.StudentDto;
import com.example.gradebook.dto.StudentGradesDto;
import com.example.gradebook.dto.StudentMeanGradeDto;
import com.example.gradebook.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepo studentRepo;

    private final GradeRepo gradeRepo;

    public StudentService(StudentRepo studentRepo, GradeRepo gradeRepo) {
        this.studentRepo = studentRepo;
        this.gradeRepo = gradeRepo;
    }

    public GroupDto<StudentDto> getGroup(int groupId) {
        List<StudentDto> studentList = new ArrayList<>();
        for (Student student : studentRepo.findByGroupId(groupId)) {
            studentList.add(new StudentDto(student));
        }
        return new GroupDto<>(studentList, studentList.size());
    }

    public GroupDto<StudentMeanGradeDto> getMeanGradeGroup(int groupId) {
        List<StudentMeanGradeDto> studentList = new ArrayList<>();
        for (Student student : studentRepo.findByGroupId(groupId)) {
            studentList.add(new StudentMeanGradeDto(student));
        }
        return new GroupDto<>(studentList, studentList.size());
    }

    public StudentGradesDto updateGradeByStudentId(int studentId, String subjectName, int mark) {
        gradeRepo.updateMarkByStudentId(mark, subjectName, studentId);
        Student student = studentRepo.getReferenceById(studentId);
        return new StudentGradesDto(student);
    }

    public GroupDto<StudentMeanGradeDto> updateGradeByStudentNameSurname(int groupId, String name, String surname,
                                                                         String subjectName, int mark) {
        List<Integer> studentIds = studentRepo.getStudentsIdByGroupNameSurname(groupId, name, surname);
        if (studentIds == null)
            return null;
        List<StudentMeanGradeDto> students = new ArrayList<>();
        for (Integer studentId : studentIds) {
            gradeRepo.updateMarkByStudentId(mark, subjectName, studentId);
            students.add(new StudentMeanGradeDto(studentRepo.getReferenceById(studentId)));
        }
        return new GroupDto<>(students, students.size());
    }
}
