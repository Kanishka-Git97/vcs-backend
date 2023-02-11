package com.vcs.backend.repository;

import com.vcs.backend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "SELECT COUNT(id) FROM appointment WHERE date=?1 AND time=?2 AND doctor=?3", nativeQuery = true)
    Integer validate(String date, String time, int doctor);

    @Query(value = "SELECT * FROM appointment WHERE doctor=?1", nativeQuery = true)
    List<Appointment> getAllByDoctor(Integer doctor);
}