package com.addamsestates.image.srevice.serviceImpl;

import com.addamsestates.image.model.PropertiesImages;
import com.addamsestates.image.repo.PropertiesImagesRepository;
import com.addamsestates.image.srevice.PropertiesImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertiesImageServiceImpl implements PropertiesImagesService {

    @Autowired
    PropertiesImagesRepository propertiesImagesRepository;


    @Override
    public PropertiesImages getByFileId(Long id) {
        return propertiesImagesRepository.getById(id);
    }

    @Override
    public List<PropertiesImages> getByPropertyId(Long id) {
        return propertiesImagesRepository.getByPropertyId(id);
    }

    @Override
    public void addPropertyImage(PropertiesImages pImage) {
            propertiesImagesRepository.save(pImage);
    }
}
