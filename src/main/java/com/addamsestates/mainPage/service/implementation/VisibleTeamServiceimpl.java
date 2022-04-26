package com.addamsestates.mainPage.service.implementation;

import com.addamsestates.mainPage.model.VisibleTeam;
import com.addamsestates.mainPage.repo.VisibleTeamRepository;
import com.addamsestates.mainPage.service.VisibleTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisibleTeamServiceimpl implements VisibleTeamService {

    @Autowired
    VisibleTeamRepository visibleTeamRepository;

    @Override
    public List<VisibleTeam> getAllMewmbers() {
        return visibleTeamRepository.findAll();
    }

    @Override
    public VisibleTeam getMembersById(Long id) {
        return visibleTeamRepository.getById(id);
    }

    @Override
    public List<VisibleTeam> getByVisible() {
        return visibleTeamRepository.getByVisible(true);
    }

    @Override
    public void addNewTeamMember(VisibleTeam vt) {
        visibleTeamRepository.save(vt);
    }
}
