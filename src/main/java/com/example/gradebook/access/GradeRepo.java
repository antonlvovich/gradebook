package com.example.gradebook.access;

import com.example.gradebook.entity.Grade;
import com.example.gradebook.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, GradeId> {
    @Modifying
    @Query(value = "UPDATE grade SET mark = ?1 WHERE subjectName = ?2 AND studentId = ?3", nativeQuery = true)
    void updateMarkByStudentId(int mark, String subjectName, int studentId);
}
