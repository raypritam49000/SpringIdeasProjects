package com.smartcontactmanager.controller;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.service.ContactService;
import com.smartcontactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;


    @GetMapping("/search/{query}")
    public ResponseEntity<?> search(@PathVariable("query") String query, Principal principal){
        System.out.println(query);

        String username = principal.getName();
        User user = this.userService.findUserByUsername(username);

        List<Contact> contacts = this.contactService.findByCnameContainingAndUser(query,user);
        return ResponseEntity.ok(contacts);
    }
}
