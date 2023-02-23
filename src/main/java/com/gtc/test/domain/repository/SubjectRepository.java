package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    List<Subject> getAll();
    Optional<Subject> getSpecific(int id);
    Subject save(Subject subject);
    Subject update(Subject subject);
    boolean delete(int id);
}
