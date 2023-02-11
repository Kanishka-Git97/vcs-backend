package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Client;
import com.vcs.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping("/register")
    public String register(@RequestBody ObjectNode data){
        return service.register(data);
    }

    @GetMapping("/all")
    public List<Client> all(){
        return service.all();
    }

    @PostMapping("/get")
    public Client get(@RequestBody ObjectNode data){
        return service.get(data.get("id").asInt());
    }

    @PostMapping("/get_by_doctor")
    public List<Client> getByDoctor(@RequestBody ObjectNode data){
        return service.getByDoctor(data.get("doctor").asInt());
    }
}
