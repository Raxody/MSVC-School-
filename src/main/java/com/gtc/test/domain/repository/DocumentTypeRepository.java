package com.gtc.test.domain.repository;

import com.gtc.test.domain.entity.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeRepository {

    List<DocumentType> getAll();
    Optional<DocumentType> getSpecific(int id);
    DocumentType save(DocumentType documentType);
    DocumentType update(DocumentType documentType);
    boolean delete(int id);
}
