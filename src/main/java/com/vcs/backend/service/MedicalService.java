package com.vcs.backend.service;

import com.vcs.backend.model.Medical;

import java.util.List;

public interface MedicalService {
    public String save(Medical medical);
    public List<Medical> getAll(Integer pet);
}
