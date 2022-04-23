package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Lettings;

import java.util.List;

public interface LettingService {

    List<Lettings> getAllLettings();

    void addNewLetting(Lettings l);

}
