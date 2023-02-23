package com.gtc.test.domain.service;

import com.gtc.test.domain.entity.Teacher;
import com.gtc.test.domain.persistence.crud.TeacherCrudRepository;
import com.gtc.test.domain.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherRepository {
    private final TeacherCrudRepository teacherCrudRepository;

    public TeacherService(TeacherCrudRepository teacherCrudRepository) {
        this.teacherCrudRepository = teacherCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> getAll() {
        return (List<Teacher>) teacherCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Teacher> getSpecific(int id) {
        return teacherCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Teacher save(Teacher teacher) {
        return teacherCrudRepository.save(teacher);
    }

    @Override
    @Transactional
    public Teacher update(Teacher teacher) {
        return getSpecific(teacher.getId()).isPresent() ?
                teacherCrudRepository.save(teacher) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(dane -> {
                    teacherCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
