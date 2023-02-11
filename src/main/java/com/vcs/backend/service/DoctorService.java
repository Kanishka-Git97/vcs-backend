package com.vcs.backend.service;

import com.vcs.backend.model.Doctor;

import java.util.List;

public interface DoctorService {

    public List<Doctor> getAll();
    public List<Doctor> getAllByAddress(String query);
    public Doctor getDoctor(int id);
}
