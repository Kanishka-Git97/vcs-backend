package com.vcs.backend.repository;

import com.vcs.backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query(value = "SELECT * FROM doctor WHERE user_ref=?1", nativeQuery = true)
    Doctor getLoginDoctor(int user);

    @Query(value = "SELECT * FROM doctor WHERE address LIKE %?1%", nativeQuery = true)
    List<Doctor> getDoctorByAddress(String query);
}