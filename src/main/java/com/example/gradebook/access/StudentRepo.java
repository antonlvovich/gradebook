package com.example.gradebook.access;

import com.example.gradebook.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM person WHERE class = ?1", nativeQuery = true)
    List<Student> findByGroupId(int groupId);

    @Query(value = "SELECT id FROM person WHERE class = ?1", nativeQuery = true)
    List<Integer> getStudentsIdByGroup(int groupId);

    @Query(value = "SELECT id FROM person WHERE class = ?1 AND firstname = ?2 AND lastname = ?3", nativeQuery = true)
    List<Integer> getStudentsIdByGroupNameSurname(int groupId, String firstName, String lastName);
}
