package com.gtc.test.domain.service;

import com.gtc.test.domain.repository.DaneRepository;
import com.gtc.test.domain.entity.Dane;
import com.gtc.test.domain.persistence.crud.DaneCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DaneService implements DaneRepository {

    private final DaneCrudRepository daneCrudRepository;

    public DaneService(DaneCrudRepository daneCrudRepository) {
        this.daneCrudRepository = daneCrudRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Dane> getAll() {
        return (List<Dane>) daneCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dane> getSpecific(int id) {
        return daneCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Dane save(Dane dane) {
        return daneCrudRepository.save(dane);
    }

    @Override
    @Transactional
    public Dane update(Dane dane) {
        return getSpecific(dane.getId()).isPresent() ?
                daneCrudRepository.save(dane) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(dane -> {
                    daneCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
