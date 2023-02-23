package com.gtc.test.domain.service;

import com.gtc.test.domain.entity.Grade;
import com.gtc.test.domain.persistence.crud.GradeCrudRepository;
import com.gtc.test.domain.repository.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService implements GradeRepository {

    private final GradeCrudRepository gradeCrudRepository;

    public GradeService(GradeCrudRepository gradeCrudRepository) {
        this.gradeCrudRepository = gradeCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Grade> getAll() {
        return (List<Grade>) gradeCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grade> getSpecific(int id) {
        return gradeCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Grade save(Grade grade) {
        return gradeCrudRepository.save(grade);
    }

    @Override
    @Transactional
    public Grade update(Grade grade) {
        return getSpecific(grade.getId()).isPresent() ?
                gradeCrudRepository.save(grade) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(dane -> {
                    gradeCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
