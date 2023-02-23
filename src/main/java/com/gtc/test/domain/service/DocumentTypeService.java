package com.gtc.test.domain.service;

import com.gtc.test.domain.entity.DocumentType;
import com.gtc.test.domain.persistence.crud.DocumentTypeCrudRepository;
import com.gtc.test.domain.repository.DocumentTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeService implements DocumentTypeRepository {

    private final DocumentTypeCrudRepository documentTypeCrudRepository;

    public DocumentTypeService(DocumentTypeCrudRepository documentTypeCrudRepository) {
        this.documentTypeCrudRepository = documentTypeCrudRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentType> getAll() {
        return (List<DocumentType>) documentTypeCrudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DocumentType> getSpecific(int id) {
        return documentTypeCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public DocumentType save(DocumentType documentType) {
        return documentTypeCrudRepository.save(documentType);
    }

    @Override
    @Transactional
    public DocumentType update(DocumentType documentType) {
        return getSpecific(documentType.getId()).isPresent() ?
                documentTypeCrudRepository.save(documentType) : null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return getSpecific(id)
                .map(documentType -> {
                    documentTypeCrudRepository.deleteById(id);
                    return Boolean.TRUE;})
                .orElse(Boolean.FALSE);
    }
}
