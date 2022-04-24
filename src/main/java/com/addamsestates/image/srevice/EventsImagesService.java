package com.addamsestates.image.srevice;

import com.addamsestates.image.model.EventsImages;

import java.util.List;

public interface EventsImagesService {

    void addNewImage(EventsImages ei);

    List<EventsImages> getAllImages();

    EventsImages getImageById(Long id);

}
