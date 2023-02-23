package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getAll();
    Optional<Student> getSpecific(int id);
    Student save(Student student);
    Student update(Student student);
    boolean delete(int id);
}
