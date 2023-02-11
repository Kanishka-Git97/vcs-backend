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
        pet.setSpecialRemarks(data.get("specialRemarks").asText());
        pet.setType(data.get("type").asText());
        pet.setClient(data.get("client").asInt());
        pet.setDoctor(data.get("doctor").asInt());
        pet.setImg(data.get("img").asText());
        repository.save(pet);
        return "Saved Pet";
    }

    public List<Pet> all(){
        return repository.findAll();
    }

    @Override
    public List<Pet> getByDoctor(Integer doctor) {
        return repository.getByDoctor(doctor);
    }

    @Override
    public String update(Pet pet) {
        repository.save(pet);
        return "Saved Pet";
    }

    @Override
    public List<Pet> getByClientAndDoctor(Integer client, Integer doctor) {
        return repository.getByDoctorAndClient(client, doctor);
    }

    @Override
    public List<Pet> getByClient(Integer client) {
        return repository.getByClient(client);
    }
}
