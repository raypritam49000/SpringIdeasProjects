package com.smartcontactmanager.service;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;

public interface UserService {
    public User saveUser(User user);

    public User findUserByUsername(String email);

//    public Contact saveContact(Contact contact);
}
