package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Medical;
import com.vcs.backend.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical")
@CrossOrigin
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @PostMapping("/add")
    public String add(@RequestBody Medical medical){
        return medicalService.save(medical);
    }

    @PostMapping("/getall")
    public List<Medical> getAll(@RequestBody ObjectNode data){
        return medicalService.getAll(data.get("pet").asInt());
    }
}
