package com.example.gradebook.access;

import com.example.gradebook.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM person WHERE class = :groupId", nativeQuery = true)
    List<Student> findByGroupId(@Param("groupId") int groupId);

    @Query(value = "SELECT id FROM person WHERE class = :groupId AND firstname = :firstName " +
            "AND lastname = :lastName", nativeQuery = true)
    List<Integer> getStudentsIdByGroupNameSurname(@Param("groupId") int groupId,
                                                  @Param("firstName") String firstName,
                                                  @Param("lastName") String lastName);
}
