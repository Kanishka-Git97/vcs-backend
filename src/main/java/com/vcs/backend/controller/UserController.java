package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Sender;
import com.vcs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Sender login(@RequestBody ObjectNode data){
        return service.validateLogin(data.get("username").asText(), data.get("password").asText());
    }

    @PostMapping("/register")
    public String register(@RequestBody ObjectNode data){
        return service.register(data);
    }


}
