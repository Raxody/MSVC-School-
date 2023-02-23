package com.gtc.test.domain.persistence.crud;

import com.gtc.test.domain.entity.Dane;
import org.springframework.data.repository.CrudRepository;

public interface DaneCrudRepository extends CrudRepository<Dane,Integer> {
}
