package com.vcs.backend.repository;

import com.vcs.backend.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalRepository extends JpaRepository<Medical, Integer> {
    @Query(value = "SELECT * FROM medical WHERE pet=?1 ORDER BY id DESC", nativeQuery = true)
    List<Medical> getAll(Integer pet);

    
}