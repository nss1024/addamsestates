package com.addamsestates.image.repo;

import com.addamsestates.image.model.UserProfileImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserProfileImagesRepository extends JpaRepository<UserProfileImages, Long> {

    public List<UserProfileImages> getByUserProfileId(Long id);

}
