package com.gtc.test.domain.service;

import com.gtc.test.domain.entity.Student;
import com.gtc.test.domain.persistence.crud.StudentCrudRepository;
import com.gtc.test.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentRepository {

    private final StudentCrudRepository studentCrudRepository;

    public StudentService(StudentCrudRepository studentCrudRepository) {
        this.studentCrudRepository = studentCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return (List<Student>) studentCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> getSpecific(int id) {
        return studentCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentCrudRepository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return getSpecific(student.getId()).isPresent() ?
                studentCrudRepository.save(student) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(student -> {
                    studentCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
