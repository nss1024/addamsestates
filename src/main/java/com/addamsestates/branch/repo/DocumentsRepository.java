package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DocumentsRepository extends JpaRepository<Documents, Long> {

    Documents findFirstByOrderByDocumentIdDesc();

}
