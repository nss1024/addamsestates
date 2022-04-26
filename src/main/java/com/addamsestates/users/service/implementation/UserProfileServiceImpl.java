package com.addamsestates.users.service.implementation;

import com.addamsestates.users.model.UserProfile;
import com.addamsestates.users.repo.UserProfileReporitory;
import com.addamsestates.users.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileReporitory userProfileReporitory;


    @Override
    public void addNewUserProfile(UserProfile userProfile) {
        userProfileReporitory.save(userProfile);
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        userProfileReporitory.save(userProfile);
    }

    @Override
    public UserProfile findLastInserteduserprofileId() {
        return userProfileReporitory.findFirstByOrderByUserProfileIdDesc();
    }
}
