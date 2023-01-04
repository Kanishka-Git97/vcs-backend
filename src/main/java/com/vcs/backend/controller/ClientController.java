package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Client;
import com.vcs.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
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
}
