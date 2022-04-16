package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BranchRepository extends JpaRepository<Branch, Long> {
}
