package com.vcs.backend.service;

import com.vcs.backend.model.Doctor;
import com.vcs.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorImpl implements DoctorService{
    @Autowired
    DoctorRepository repository;

    public List<Doctor> getAll(){
        return  repository.findAll();
    }

    public List<Doctor> getAllByAddress(String query){
        return repository.getDoctorByAddress(query);
    }

    public Doctor getDoctor(int id){
        return  repository.findById(id).orElse(null);
    }
}
