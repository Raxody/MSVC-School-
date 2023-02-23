package com.gtc.test.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
@Getter
@Setter
public class Teacher {
    @Id
    Integer id;
    @Column(name = "id_tipodocumento")
    Integer typeDocumentId;
    @Column(name = "numerodocumento")
    String documentNumber;
    @Column(name = "nombres")
    String names;
    @Column(name = "apellidos")
    String lastNames;
    @Column(name = "fecha_nacimiento")
    String dateBirth;
    @Column(name = "id_grado")
    String gradeId;
    @Column(name = "id_dane")
    String daneId;
    @Column(name = "direccion")
    Integer address;
    @Column(name = "email")
    String email;
    @Column(name = "fijo")
    String numberPhone;
    @Column(name = "celular")
    String cellphoneNumber;




}
