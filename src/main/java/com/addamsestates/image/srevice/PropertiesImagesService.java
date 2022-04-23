package com.addamsestates.image.srevice;

import com.addamsestates.image.model.PropertiesImages;

import java.util.List;

public interface PropertiesImagesService {

    PropertiesImages getByFileId(Long id);

    List<PropertiesImages> getByPropertyId(Long id);

    void addPropertyImage(PropertiesImages pImage);

}
