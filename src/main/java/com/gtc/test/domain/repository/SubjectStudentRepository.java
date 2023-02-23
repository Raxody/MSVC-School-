package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.SubjectStudentPK;
import com.gtc.test.domain.entity.SubjectStudent;

import java.util.List;
import java.util.Optional;

public interface SubjectStudentRepository {

    List<SubjectStudent> getAll();
    Optional<SubjectStudent> getProduct(SubjectStudentPK subjectStudentPK);
    SubjectStudent save(SubjectStudent subject);
    SubjectStudent update(SubjectStudent subject);
    void delete(SubjectStudentPK subjectStudentPK);
}
