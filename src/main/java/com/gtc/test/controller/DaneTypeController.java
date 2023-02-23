package com.gtc.test.controller;

import com.gtc.test.domain.entity.Dane;
import com.gtc.test.domain.entity.DaneType;
import com.gtc.test.domain.service.DaneService;
import com.gtc.test.domain.service.DaneTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daneType")
public class DaneTypeController {
    private final DaneTypeService daneTypeService;

    public DaneTypeController(DaneTypeService daneTypeService) {
        this.daneTypeService = daneTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<DaneType>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(daneTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DaneType> findSpecific(@PathVariable("id") int id){
        return daneTypeService
                .getSpecific(id)
                .map(daneType -> ResponseEntity.ok().body(daneType))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<DaneType> save(@RequestBody DaneType daneType){
        return new ResponseEntity<>(daneTypeService.save(daneType), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DaneType> update(@RequestBody DaneType daneType){
        return daneTypeService.update(daneType) != null ?
                new ResponseEntity<>(daneType,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return daneTypeService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}
