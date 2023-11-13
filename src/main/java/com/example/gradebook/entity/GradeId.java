package com.example.gradebook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GradeId implements Serializable {
    @Column(name = "studentid", nullable = false)
    private Integer studentId;

    @Column(name = "subjectname", nullable = false, length = 15)
    private String subjectName;

    @Column(name = "classid", nullable = false)
    private Short groupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GradeId entity = (GradeId) o;
        return studentId.equals(entity.studentId) &&
                subjectName.equals(entity.subjectName) &&
                 groupId.equals(entity.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectName, groupId);
    }

}