package com.gtc.test.controller;

import com.gtc.test.domain.entity.Grade;
import com.gtc.test.domain.entity.Student;
import com.gtc.test.domain.service.GradeService;
import com.gtc.test.domain.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findSpecific(@PathVariable("id") int id){
        return studentService
                .getSpecific(id)
                .map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        return studentService.update(student) != null ?
                new ResponseEntity<>(student,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return studentService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}