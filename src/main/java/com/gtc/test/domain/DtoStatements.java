package com.gtc.test.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoStatements {

    private String teacherName;
    private String teacherLastName;
    private String courseName;
    private String studentName;
    private String studentLastName;
    private Double score;

    public DtoStatements(String teacherName, String teacherLastName, String courseName, String studentName, String studentLastName, Double score) {
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.score = score;
    }
}
