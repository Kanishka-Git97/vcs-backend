package com.vcs.backend.service;

import com.vcs.backend.model.Education;
import com.vcs.backend.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationImpl implements EducationService{

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public Education educationSave(Education education) {
       return educationRepository.save(education);
    }
}
