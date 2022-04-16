package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Events;

import java.util.List;

public interface EventsService {

    List<Events> getAllEvents();

    Events geEventById(Long id);

    List <Events> getActiveEvents();

}
