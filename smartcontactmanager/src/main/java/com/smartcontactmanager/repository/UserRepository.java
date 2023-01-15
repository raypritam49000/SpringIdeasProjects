package com.smartcontactmanager.repository;

import com.smartcontactmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("from User where email = :email")
    public User findUserByUsername(@Param("email") String email);
}
