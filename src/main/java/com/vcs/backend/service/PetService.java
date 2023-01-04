package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Pet;

import java.util.List;

public interface PetService {
    public String save(ObjectNode data);
    public List<Pet> all();
}
