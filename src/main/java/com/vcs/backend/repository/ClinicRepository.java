package com.vcs.backend.repository;

import com.vcs.backend.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

    @Query(value = "DELETE FROM clinic WHERE id=?1", nativeQuery = true)
    void delete(int id);

    @Query(value = "SELECT COUNT(id) FROM clinic WHERE reg=?1", nativeQuery = true)
    Integer validateBusiness(String reg);

    @Query(value = "SELECT COUNT(id) FROM clinic WHERE doctor=?1", nativeQuery = true)
    Integer getClinicCount(int Doc);
}