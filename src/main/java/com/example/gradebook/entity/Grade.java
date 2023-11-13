package com.example.gradebook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
    @EmbeddedId
    private GradeId id;

    @MapsId("studentid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "studentid", nullable = false)
    private Student student;

    @Column(name = "mark", nullable = false)
    private Short mark;

}