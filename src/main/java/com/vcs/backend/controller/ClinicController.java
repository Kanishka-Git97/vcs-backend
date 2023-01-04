package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Clinic;
import com.vcs.backend.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clinic")
@CrossOrigin
public class ClinicController {
    @Autowired
    private ClinicService service;

    @PostMapping("/register")
    public String register(@RequestBody ObjectNode data){
        return service.save(data);
    }

    @GetMapping("all")
    public List<Clinic> all(){
        return service.all();
    }
    @PostMapping("/delete")
    public String delete(@RequestBody ObjectNode data){
        return service.delete(data.get("id").asInt());
    }
}
