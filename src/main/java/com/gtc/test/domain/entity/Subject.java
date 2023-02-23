package com.gtc.test.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignatura")
@Getter
@Setter
public class Subject {

    @Id
    Integer id;
    @Column(name = "descripcion")
    String description;
    @Column(name = "id_docente")
    Integer idTeacher;

}
