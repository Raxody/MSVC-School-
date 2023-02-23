package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeRepository {
    List<Grade> getAll();
    Optional<Grade> getSpecific(int id);
    Grade save(Grade grade);
    Grade update(Grade grade);
    boolean delete(int id);
}
