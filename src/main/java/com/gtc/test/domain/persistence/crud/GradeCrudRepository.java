package com.gtc.test.domain.persistence.crud;

import com.gtc.test.domain.entity.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeCrudRepository extends CrudRepository<Grade,Integer> {


}
