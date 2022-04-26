package com.addamsestates.mainPage.service;

import com.addamsestates.mainPage.model.VisibleTeam;

import java.util.List;
import java.util.Optional;

public interface VisibleTeamService {

    List<VisibleTeam> getAllMewmbers();

    VisibleTeam getMembersById(Long id);

    List<VisibleTeam> getByVisible();

    void addNewTeamMember(VisibleTeam vt);

}
