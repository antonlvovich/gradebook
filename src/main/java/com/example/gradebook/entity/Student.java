package com.example.gradebook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;

    @Column(name = "firstname", nullable = false, length = 15)
    private String firstName;

    @Column(name = "age", nullable = false)
    private Short age;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "class", nullable = false)
    private StudentClass classId;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Grade> grades = new HashSet<>();

    public double getMeanGrade() {
        double sum = 0.0;
        for (var grade : grades)
            sum += grade.getMark();
        return sum / grades.size();
    }
}