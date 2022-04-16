package com.addamsestates.mainPage.service.serviceImplementation;

import com.addamsestates.mainPage.model.VisibleTeam;
import com.addamsestates.mainPage.repo.VisibleTeamRepository;
import com.addamsestates.mainPage.service.VisibleTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class VisibleTeamServiceImpl implements VisibleTeamService{
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
    public List<VisibleTeam> getByVisible(){
        return visibleTeamRepository.getByVisible(true);
    }
}
