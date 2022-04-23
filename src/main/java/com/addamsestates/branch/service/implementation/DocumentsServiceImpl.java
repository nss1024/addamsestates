package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Documents;
import com.addamsestates.branch.repo.DocumentsRepository;
import com.addamsestates.branch.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsServiceImpl implements DocumentsService {
    @Autowired
    private DocumentsRepository documentsRepository;


    @Override
    public List<Documents> getAllDocuments() {
        return documentsRepository.findAll();
    }

    @Override
    public Documents getLastInserted() {
        return documentsRepository.findFirstByOrderByDocumentIdDesc();
    }

    @Override
    public void addDocument(Documents d) {
        documentsRepository.save(d);
    }
}
