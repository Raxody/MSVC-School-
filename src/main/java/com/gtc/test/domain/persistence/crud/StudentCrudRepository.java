package com.gtc.test.domain.persistence.crud;

import com.gtc.test.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentCrudRepository extends CrudRepository<Student,Integer> {

}
