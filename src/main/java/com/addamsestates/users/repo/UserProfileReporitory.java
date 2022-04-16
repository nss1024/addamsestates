package com.addamsestates.users.repo;

import com.addamsestates.users.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserProfileReporitory extends JpaRepository<UserProfile, Long> {
}
