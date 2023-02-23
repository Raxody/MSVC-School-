package com.gtc.test.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "id")
@Getter
@Setter
public class Grade {

    @Id
    Integer id;
    @Column(name = "descripcion")
    String description;

}
