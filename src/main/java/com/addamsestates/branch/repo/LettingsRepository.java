package com.addamsestates.branch.repo;

import com.addamsestates.branch.model.Lettings;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LettingsRepository extends JpaRepository<Lettings, Long> {
}
