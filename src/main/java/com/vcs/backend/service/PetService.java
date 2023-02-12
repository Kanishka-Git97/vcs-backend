package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Pet;

import java.util.List;

public interface PetService {
    public String save(ObjectNode data);
    public List<Pet> all();
    public List<Pet> getByDoctor(Integer doctor);
    public String update(Pet pet);
    public List<Pet> getByClientAndDoctor(Integer client, Integer doctor);
    public List<Pet> getByClient(Integer client);
    public Pet get(Integer id);
}
