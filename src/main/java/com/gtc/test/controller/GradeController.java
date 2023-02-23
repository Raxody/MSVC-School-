package com.gtc.test.controller;

import com.gtc.test.domain.entity.Grade;
import com.gtc.test.domain.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping()
    public ResponseEntity<List<Grade>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> findSpecific(@PathVariable("id") int id){
        return gradeService
                .getSpecific(id)
                .map(daneType -> ResponseEntity.ok().body(daneType))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<Grade> save(@RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.save(grade), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Grade> update(@RequestBody Grade grade){
        return gradeService.update(grade) != null ?
                new ResponseEntity<>(grade,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return gradeService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}