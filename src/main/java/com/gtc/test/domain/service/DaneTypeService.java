package com.gtc.test.domain.service;

import com.gtc.test.domain.repository.DaneTypeRepository;
import com.gtc.test.domain.entity.DaneType;
import com.gtc.test.domain.persistence.crud.DaneTypeCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DaneTypeService implements DaneTypeRepository {

    private final DaneTypeCrudRepository daneTypeCrudRepository;

    public DaneTypeService(DaneTypeCrudRepository daneTypeCrudRepository) {
        this.daneTypeCrudRepository = daneTypeCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DaneType> getAll() {
        return (List<DaneType>) daneTypeCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DaneType> getSpecific(int id) {
        return daneTypeCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public DaneType save(DaneType daneType) {
        return daneTypeCrudRepository.save(daneType);
    }

    @Override
    @Transactional
    public DaneType update(DaneType daneType) {
        return getSpecific(daneType.getId()).isPresent() ?
                daneTypeCrudRepository.save(daneType) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(dane -> {
                    daneTypeCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
