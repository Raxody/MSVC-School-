package com.gtc.test.domain.persistence.crud;

import com.gtc.test.domain.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectCrudRepository  extends CrudRepository<Subject,Integer> {


}
