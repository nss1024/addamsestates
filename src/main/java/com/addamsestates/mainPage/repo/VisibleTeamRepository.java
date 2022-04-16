package com.addamsestates.mainPage.repo;

import com.addamsestates.mainPage.model.VisibleTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisibleTeamRepository extends JpaRepository<VisibleTeam, Long> {

    List<VisibleTeam> getByVisible(Boolean isVisible);

}
