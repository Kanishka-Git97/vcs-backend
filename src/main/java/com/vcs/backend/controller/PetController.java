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
}
