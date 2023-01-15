package com.smartcontactmanager.service;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Page<Contact> getAllContacts(int id, Pageable pageable) {
       return this.contactRepository.findContactByUser(id,pageable);
    }

    @Override
    public Contact getContactById(int id) {
        return this.contactRepository.findById(id).get();
    }

    @Override
    public void deleteContact(Contact contact) {
        this.contactRepository.delete(contact);
    }

    @Override
    public void saveContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    @Override
    public List<Contact> findByCnameContainingAndUser(String name, User user) {
        return this.contactRepository.findByCnameContainingAndUser(name,user);
    }


}
