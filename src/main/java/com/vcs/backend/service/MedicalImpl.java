package com.vcs.backend.service;

import com.vcs.backend.model.Medical;
import com.vcs.backend.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalImpl implements MedicalService{
    @Autowired
    private MedicalRepository medicalRepository;

    @Override
    public String save(Medical medical) {
        medicalRepository.save(medical);
        return "True";
    }

    @Override
    public List<Medical> getAll(Integer pet) {
        return medicalRepository.getAll(pet);
    }
}
