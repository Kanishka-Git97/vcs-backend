package com.vcs.backend.repository;

import com.vcs.backend.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeightRepository extends JpaRepository<Weight, Integer> {

    @Query(value = "SELECT * FROM weight WHERE pet=?1", nativeQuery = true)
    public List<Weight> getAll(Integer pet);
}