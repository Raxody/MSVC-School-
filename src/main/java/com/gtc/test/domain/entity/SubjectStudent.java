package com.gtc.test.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class SubjectStudent {

    @EmbeddedId
    SubjectStudentPK subjectStudentPK;
    @Column(name = "nota")
    Double score;
    @Column(name = "period")
    Integer period;

}
