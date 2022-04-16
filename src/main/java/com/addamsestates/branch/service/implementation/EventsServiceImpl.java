package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Events;
import com.addamsestates.branch.repo.EventsRepository;
import com.addamsestates.branch.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Events geEventById(Long id) {
        return eventsRepository.getById(id);
    }

    @Override
    public List<Events> getActiveEvents() {
        return eventsRepository.getByEventActive(true);
    }
}
