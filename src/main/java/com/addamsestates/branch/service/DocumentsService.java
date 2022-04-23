package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Documents;

import java.util.List;

public interface DocumentsService {

    List<Documents> getAllDocuments();

    Documents getLastInserted();

    void addDocument(Documents d);

}
