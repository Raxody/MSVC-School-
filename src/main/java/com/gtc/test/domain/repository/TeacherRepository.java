package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    List<Teacher> getAll();
    Optional<Teacher> getSpecific(int id);
    Teacher save(Teacher teacher);
    Teacher update(Teacher teacher);
    boolean delete(int id);
}
