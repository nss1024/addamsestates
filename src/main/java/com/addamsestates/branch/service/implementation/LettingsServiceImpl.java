package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Lettings;
import com.addamsestates.branch.repo.LettingsRepository;
import com.addamsestates.branch.service.LettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LettingsServiceImpl implements LettingService {

    @Autowired
    private LettingsRepository lettingsRepository;


    @Override
    public List<Lettings> getAllLettings() {
        return lettingsRepository.findAll();
    }

    @Override
    public void addNewLetting(Lettings l) {
        lettingsRepository.save(l);
    }
}
