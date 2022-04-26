package com.addamsestates.users.service;

import com.addamsestates.users.model.UserProfile;

public interface UserProfileService {

    void addNewUserProfile (UserProfile userProfile);

    void updateUserProfile (UserProfile userProfile);

    UserProfile findLastInserteduserprofileId();

}
