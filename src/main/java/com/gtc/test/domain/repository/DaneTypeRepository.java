package com.gtc.test.domain.repository;
import com.gtc.test.domain.entity.DaneType;

import java.util.List;
import java.util.Optional;

public interface DaneTypeRepository {
    List<DaneType> getAll();
    Optional<DaneType> getSpecific(int id);
    DaneType save(DaneType daneType);
    DaneType update(DaneType daneType);
    boolean delete(int id);
}
