package com.gtc.test.domain.persistence.crud;

import com.gtc.test.domain.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherCrudRepository extends CrudRepository<Teacher,Integer> {

}
