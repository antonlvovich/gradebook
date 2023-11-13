package com.example.gradebook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PlanId implements Serializable {

    @Column(name = "classid", nullable = false)
    private Short classid;

    @Column(name = "subjectname", nullable = false, length = 15)
    private String subjectname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlanId entity = (PlanId) o;
        return Objects.equals(this.subjectname, entity.subjectname) &&
                Objects.equals(this.classid, entity.classid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectname, classid);
    }
}