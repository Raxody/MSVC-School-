package com.gtc.test.domain.service;

import com.gtc.test.domain.DtoStatements;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatementsService {

    private final JdbcTemplate jdbcTemplate;

    public StatementsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DtoStatements> coursesWithStudentsUnder31() {
        List<DtoStatements> dtoStatementMajorNoteAs31s = new ArrayList<>();
        String sql = "SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor,a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,ea.nota AS notaMateria FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) WHERE ea.nota > 3.1 ORDER BY notaMateria DESC;";
        jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            while (resultSet.next()){
                dtoStatementMajorNoteAs31s.add(
                        new DtoStatements(resultSet.getString("nombreProfesor"),
                                resultSet.getString("apellidosProfesor"),
                                resultSet.getString("nombreMateria"),
                                resultSet.getString("nombreEstudiante"),
                                resultSet.getString("apellidoEstudiante"),
                                resultSet.getDouble("notaMateria")));
            }
        });
        return dtoStatementMajorNoteAs31s;
    }


    public DtoStatements majorScore() {
        List<DtoStatements> majorScore = new ArrayList<>();
        String sql = "SELECT p.nombres AS nombreProfesor,p.apellidos AS apellidosProfesor, a.descripcion AS nombreMateria,e.nombre AS nombreEstudiante,e.apellidos AS apellidoEstudiante,ea.nota AS notaMateria\n FROM estudiante AS e JOIN estudiante_asignatura AS ea ON (ea.id_estudiante = e.id) JOIN asignatura as a ON (ea.id_asignatura = a.id) JOIN docente AS p ON (p.id = a.id_docente) ;";
        jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            while (resultSet.next()){
                majorScore.add(
                        new DtoStatements(resultSet.getString("nombreProfesor"),
                                resultSet.getString("apellidosProfesor"),
                                resultSet.getString("nombreMateria"),
                                resultSet.getString("nombreEstudiante"),
                                resultSet.getString("apellidoEstudiante"),
                                resultSet.getDouble("notaMateria")));
            }
        });

        Double mayor = majorScore.get(0).getScore();
        int position = 0;

        for (int i = 0; i < majorScore.size(); i++) {
            if (majorScore.get(i).getScore() > mayor) {
                mayor = majorScore.get(i).getScore();
                position = i;
            }
        }
        return majorScore.get(position);
    }
}
