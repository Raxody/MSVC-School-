package com.gtc.test.domain.service;

import com.gtc.test.domain.entity.Subject;
import com.gtc.test.domain.repository.SubjectRepository;
import com.gtc.test.domain.persistence.crud.SubjectCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements SubjectRepository {

    private final SubjectCrudRepository subjectCrudRepository;

    public SubjectService(SubjectCrudRepository subjectCrudRepository) {
        this.subjectCrudRepository = subjectCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subject> getAll() {
        return (List<Subject>) subjectCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> getSpecific(int id) {
        return subjectCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Subject save(Subject subject) {
        return subjectCrudRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject update(Subject subject) {
        return getSpecific(subject.getId()).isPresent() ?
                subjectCrudRepository.save(subject) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(subject -> {
                    subjectCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
