package com.gtc.test.controller;

import com.gtc.test.domain.entity.DaneType;
import com.gtc.test.domain.entity.DocumentType;
import com.gtc.test.domain.service.DaneTypeService;
import com.gtc.test.domain.service.DocumentTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentType")
public class DocumentTypeController{
    private final DocumentTypeService documentTypeService;

    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<DocumentType>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(documentTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> findSpecific(@PathVariable("id") int id){
        return documentTypeService
                .getSpecific(id)
                .map(daneType -> ResponseEntity.ok().body(daneType))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public ResponseEntity<DocumentType> save(@RequestBody DocumentType documentType){
        return new ResponseEntity<>(documentTypeService.save(documentType), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DocumentType> update(@RequestBody DocumentType documentType){
        return documentTypeService.update(documentType) != null ?
                new ResponseEntity<>(documentType,HttpStatus.ACCEPTED) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return documentTypeService.delete(id) ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) :
                new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}