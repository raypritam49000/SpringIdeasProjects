package com.smartcontactmanager.service;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {
    public abstract Page<Contact> getAllContacts(int id,Pageable pageable);
    public abstract Contact getContactById(int id);
    public abstract void deleteContact(Contact contact);
    public abstract  void saveContact(Contact contact);
    public abstract List<Contact> findByCnameContainingAndUser(String name, User user);

}
