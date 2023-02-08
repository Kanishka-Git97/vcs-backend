package com.vcs.backend.repository;

import com.vcs.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT * FROM client WHERE referral =?1", nativeQuery = true)
    List<Client> getByDoctor(Integer doctor);
}