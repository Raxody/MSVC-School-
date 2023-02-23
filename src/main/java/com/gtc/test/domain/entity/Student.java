package com.gtc.test.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class Student {
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
    @Column(name = "asig_dictadas")
    Integer subjectDidactics;
    @Column(name = "grado_escolaridad")
    String grade;
    @Column(name = "id_gradoresponsable")
    Integer responsibleGrade;
    @Column(name = "email")
    String email;
    @Column(name = "fijo")
    String numberPhone;
    @Column(name = "celular")
    String cellphoneNumber;
}
