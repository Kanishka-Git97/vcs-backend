package com.vcs.backend.repository;

import com.vcs.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT COUNT(id) FROM user WHERE username=?1 and password=?2", nativeQuery = true)
    int validateUser(String username, String password);


    @Query(value = "SELECT * FROM user WHERE username=?1 and password=?2 LIMIT 1", nativeQuery = true)
    User loggedUser(String username, String password);
}