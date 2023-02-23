package com.gtc.test.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dane")
@Getter
@Setter
public class Dane {
    @Id
    Integer id;
    @Column(name = "descripcion")
    String description;
    @Column(name = "id_tipodane")
    Integer daneTypeId;

}
