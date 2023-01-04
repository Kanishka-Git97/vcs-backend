package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Clinic;

import java.util.List;

public interface ClinicService {
    public String save(ObjectNode data);
    public List<Clinic> all();
    public String delete(int id);
}
