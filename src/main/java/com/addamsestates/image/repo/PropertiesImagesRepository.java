package com.addamsestates.image.repo;

import com.addamsestates.image.model.PropertiesImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertiesImagesRepository extends JpaRepository<PropertiesImages,Long> {

    List<PropertiesImages> getByPropertyId(Long id);

}
