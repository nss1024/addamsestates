package com.addamsestates.users.repo;

import com.addamsestates.users.model.UserProfile;
import com.addamsestates.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserProfileReporitory extends JpaRepository<UserProfile, Long> {

    UserProfile findFirstByOrderByUserProfileIdDesc();

}
