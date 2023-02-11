package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Doctor;
import com.vcs.backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService service;


    @GetMapping("/all")
    public List<Doctor> all(){
        return service.getAll();
    }

    @PostMapping("/findbyaddress")
    public List<Doctor> findByAddress(@RequestBody ObjectNode data){
        return service.getAllByAddress(data.get("query").asText());
    }

    @PostMapping("/find")
    public Doctor find(@RequestBody ObjectNode data){
        return service.getDoctor(data.get("id").asInt());
    }
}
