package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Pet;
import com.vcs.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@CrossOrigin
public class PetController {
    @Autowired
    private PetService service;

    @PostMapping("/register")
    public String register(@RequestBody ObjectNode data){
        return  service.save(data);
    }
    @GetMapping("/all")
    public List<Pet> all(){
        return service.all();
    }

    @PostMapping("/get_by_doctor")
    public List<Pet> getByDoctor(@RequestBody ObjectNode data){
        return service.getByDoctor(data.get("doctor").asInt());
    }

    @PostMapping("/update")
    public String update(@RequestBody Pet pet){
        return service.update(pet);
    }

    @PostMapping("/getforappointment")
    public List<Pet> getForAppointment(@RequestBody ObjectNode data){
        return service.getByClientAndDoctor(data.get("client").asInt(), data.get("doctor").asInt());
    }

    @PostMapping("/mypets")
    public List<Pet> myPets(@RequestBody ObjectNode data){
        return service.getByClient(data.get("client").asInt());
    }
}
