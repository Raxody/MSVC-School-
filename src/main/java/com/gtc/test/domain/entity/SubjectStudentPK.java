package com.gtc.test.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class SubjectStudentPK implements Serializable {
    private static final long serialVersionUID = -5488239503977742237L;
    @Column(name = "id_estudiante")
    Integer studentId;
    @Column(name = "id_asignatura")
    Integer subjectId;
}
