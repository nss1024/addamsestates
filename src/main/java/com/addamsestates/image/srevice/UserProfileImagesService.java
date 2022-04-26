package com.addamsestates.image.srevice;

import com.addamsestates.image.model.UserProfileImages;

import java.util.List;


public interface UserProfileImagesService {

    UserProfileImages getImage(Long id);

    List<UserProfileImages> getAllImages();

    List<UserProfileImages> getAllImagesByEntityId(Long id);

    void addNewImage(UserProfileImages userProfileImage);

    void UpdateImage(UserProfileImages userProfileImage);

}
