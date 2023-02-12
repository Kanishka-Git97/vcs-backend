package com.vcs.backend.repository;

import com.vcs.backend.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

    @Query(value = "SELECT * FROM certificate WHERE doctor=?1",nativeQuery = true)
    List<Certificate> all(Integer doctor);
}