package com.vcs.backend.repository;
import com.vcs.backend.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value = "SELECT * FROM pet WHERE doctor=?1", nativeQuery = true)
    public List<Pet> getByDoctor(Integer doctor);

    @Query(value = "SELECT * FROM pet WHERE client=?1 AND doctor=?2", nativeQuery = true)
    public List<Pet> getByDoctorAndClient(Integer client, Integer doctor);

    @Query(value = "SELECT * FROM pet WHERE client=?1", nativeQuery = true)
    public List<Pet> getByClient(Integer client);
}