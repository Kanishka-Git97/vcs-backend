package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Pet;
import com.vcs.backend.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetImpl implements PetService{
    @Autowired
    private PetRepository repository;

    public String save(ObjectNode data){
        Pet pet = new Pet();
        pet.setName(data.get("name").asText());
        pet.setBreed(data.get("breed").asText());
        pet.setDob(data.get("dob").asText());
        pet.setSex(data.get("sex").asText());
        pet.setSpecialRemarks(data.get("remark").asText());
        pet.setType(data.get("type").asText());
        pet.setClient(data.get("client").asInt());
        if(data.get("doctor")!=null){
            pet.setDoctor(data.get("doctor").asInt());
        }
        repository.save(pet);
        return "Saved Pet";
    }

    public List<Pet> all(){
        return repository.findAll();
    }
}
