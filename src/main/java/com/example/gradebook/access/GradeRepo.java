package com.example.gradebook.access;

import com.example.gradebook.entity.Grade;
import com.example.gradebook.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, GradeId> {
    @Modifying
    @Query(value = "UPDATE grade SET mark = :mark WHERE subjectName = :subjectName AND studentId = :studentId", nativeQuery = true)
    void updateMarkByStudentId(@Param("mark") int mark, @Param("subjectName") String subjectName,
                               @Param("studentId") int studentId);
}
