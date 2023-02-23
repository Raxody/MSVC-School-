package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.Dane;

import java.util.List;
import java.util.Optional;

public interface DaneRepository {
    List<Dane> getAll();
    Optional<Dane> getSpecific(int id);
    Dane save(Dane dane);
    Dane update(Dane dane);
    boolean delete(int id);

}
