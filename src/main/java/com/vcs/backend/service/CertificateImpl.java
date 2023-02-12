package com.vcs.backend.service;

import com.vcs.backend.model.Certificate;
import com.vcs.backend.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateImpl implements CertificateService{
    @Autowired
    private CertificateRepository repository;

    @Override
    public String apply(Certificate certificate) {
        repository.save(certificate);
        return "true";
    }

    @Override
    public List<Certificate> all(Integer doctor) {
        return repository.all(doctor);
    }

}
