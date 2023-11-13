package com.example.gradebook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto<T> {
    @JsonProperty("students")
    private List<T> studentstoList;

    private int size;
}
