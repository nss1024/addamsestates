package com.addamsestates.users.repo;

import com.addamsestates.branch.model.Events;
import com.addamsestates.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Users, Long> {

    public Users getByUserName(String userName);

    Users findFirstByOrderByIdDesc();

}
