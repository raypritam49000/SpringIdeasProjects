package com.smartcontactmanager.service;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String email) {
        return this.userRepository.findUserByUsername(email);
    }

}
