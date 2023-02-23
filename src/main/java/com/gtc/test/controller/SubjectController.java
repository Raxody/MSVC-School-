package com.gtc.test.controller;

import com.gtc.test.domain.entity.Student;
import com.gtc.test.domain.entity.Subject;
import com.gtc.test.domain.service.StudentService;
import com.gtc.test.domain.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping()
    public ResponseEntity<List<Subject>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findSpecific(@PathVariable("id") int id){
        return subjectService
                .getSpecific(id)
                .map(subject -> ResponseEntity.ok().body(subject))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<Subject> save(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Subject> update(@RequestBody Subject subject){
        return subjectService.update(subject) != null ?
                new ResponseEntity<>(subject,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return subjectService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}