package com.example.gradebook.dto;

import com.example.gradebook.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    protected String subjectName;

    protected int mark;

    public GradeDto(Grade grade) {
        this.subjectName = grade.getId().getSubjectName();
        this.mark = grade.getMark();
    }
}
