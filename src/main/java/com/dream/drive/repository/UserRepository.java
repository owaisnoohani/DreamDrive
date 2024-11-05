package com.dream.drive.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dream.drive.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}