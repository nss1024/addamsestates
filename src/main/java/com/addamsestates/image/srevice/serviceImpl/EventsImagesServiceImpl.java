package com.addamsestates.image.srevice.serviceImpl;

import com.addamsestates.image.model.EventsImages;
import com.addamsestates.image.repo.EventsImagesRepository;
import com.addamsestates.image.srevice.EventsImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsImagesServiceImpl implements EventsImagesService {

    @Autowired
    EventsImagesRepository eventsImagesRepository;


    @Override
    public void addNewImage(EventsImages ei) {
        eventsImagesRepository.save(ei);
    }

    @Override
    public void deleteEventsImage(Long id) {
        eventsImagesRepository.deleteById(id);
    }


    @Override
    public List<EventsImages> getAllImages() {
        return eventsImagesRepository.findAll();
    }

    @Override
    public EventsImages getImageById(Long id) {
        return eventsImagesRepository.getById(id);
    }
}
