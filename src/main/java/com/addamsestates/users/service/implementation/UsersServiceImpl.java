package com.addamsestates.users.service.implementation;

import com.addamsestates.users.model.Users;
import com.addamsestates.users.repo.UserRepository;
import com.addamsestates.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users getUserByUserName(String name) {
        return userRepository.getByUserName(name);
    }

    @Override
    public void addNewUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users findLastInsertedUserId() {
        return userRepository.findFirstByOrderByIdDesc();
    }
}
