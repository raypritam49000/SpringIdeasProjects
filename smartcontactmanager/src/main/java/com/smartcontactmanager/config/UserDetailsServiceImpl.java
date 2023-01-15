package com.smartcontactmanager.config;

import com.smartcontactmanager.models.User;
import com.smartcontactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // fetch the username from database
        User user = this.userService.findUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Could not found User !!!!");
        }
        UserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }
}
