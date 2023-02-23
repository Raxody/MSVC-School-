package com.gtc.test.controller;

import com.gtc.test.domain.DtoStatements;
import com.gtc.test.domain.service.StatementsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// Para probar las consultas 4 y 5

// http://localhost:8007/msvcSchool/statements/coursesWithStudentsUnder31
// http://localhost:8007/msvcSchool/statements/majorScore
@RestController
@RequestMapping("/statements")
public class StatementsController {

    private final StatementsService statement;

    public StatementsController(StatementsService statement) {
        this.statement = statement;
    }


    @GetMapping("/coursesWithStudentsUnder31")
    public ResponseEntity<List<DtoStatements>> coursesWithStudentsUnder31(){
        return ResponseEntity.status(HttpStatus.OK).body(statement.coursesWithStudentsUnder31());
    }


    @GetMapping("/majorScore")
    public ResponseEntity<DtoStatements> majorScore(){
        return ResponseEntity.status(HttpStatus.OK).body(statement.majorScore());
    }
}
