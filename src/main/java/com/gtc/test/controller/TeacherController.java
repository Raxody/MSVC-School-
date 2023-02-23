package com.gtc.test.controller;
import com.gtc.test.domain.entity.Teacher;
import com.gtc.test.domain.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public ResponseEntity<List<Teacher>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findSpecific(@PathVariable("id") int id){
        return teacherService
                .getSpecific(id)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher){
        return teacherService.update(teacher) != null ?
                new ResponseEntity<>(teacher,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return teacherService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}