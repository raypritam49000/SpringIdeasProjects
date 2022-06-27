package com.smartcontactmanager.repository;

import com.smartcontactmanager.models.Contact;
import com.smartcontactmanager.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    //Contact Per Page -5
    //currentPage-page
    @Query("from Contact as c where c.user.id =:userId")
    public Page<Contact> findContactByUser(@Param("userId") int id,Pageable pageable);

    //search logic
    public List<Contact> findByCnameContainingAndUser(String name, User user);
}
