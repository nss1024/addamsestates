package com.addamsestates.image.srevice.serviceImpl;

import com.addamsestates.image.model.UserProfileImages;
import com.addamsestates.image.repo.UserProfileImagesRepository;
import com.addamsestates.image.srevice.UserProfileImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProfileImageServiceImpl implements UserProfileImagesService {

    @Autowired
    UserProfileImagesRepository userProfileImagesRepository;
    @Override
    public UserProfileImages getImage(Long id) {
        return userProfileImagesRepository.getById(id);
    }

    @Override
    public List<UserProfileImages> getAllImages() {
        return userProfileImagesRepository.findAll();
    }

    @Override
    public List<UserProfileImages> getAllImagesByEntityId(Long id) {
        return userProfileImagesRepository.getByUserProfileId(id);
    }

    @Override
    public void addNewImage(UserProfileImages userProfileImage) {
            userProfileImagesRepository.save(userProfileImage);
    }

    @Override
    public void UpdateImage(UserProfileImages userProfileImage) {
        userProfileImagesRepository.save(userProfileImage);
    }
}
