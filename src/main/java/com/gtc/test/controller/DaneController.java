package com.gtc.test.controller;

import com.gtc.test.domain.entity.Dane;
import com.gtc.test.domain.service.DaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dane")
public class DaneController {

    private final DaneService daneService;

    public DaneController(DaneService daneService) {
        this.daneService = daneService;
    }

    @GetMapping()
    public ResponseEntity<List<Dane>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(daneService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dane> findSpecific(@PathVariable("id") int id){
        return daneService
                .getSpecific(id)
                .map(dane -> ResponseEntity.ok().body(dane))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<Dane> save(@RequestBody Dane dane){
        return new ResponseEntity<>(daneService.save(dane), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Dane> update(@RequestBody Dane dane){
        return daneService.update(dane) != null ?
                new ResponseEntity<>(dane,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return daneService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}
