package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Weight;
import com.vcs.backend.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/weight")
@CrossOrigin
public class WeightController {
    @Autowired
    private WeightService weightService;

    @PostMapping("/add")
    public String add(@RequestBody Weight data){
        return weightService.save(data);
    }

    @PostMapping("/getall")
    public List<Weight> getAll(@RequestBody ObjectNode data){
        return weightService.getAll(data.get("pet").asInt());
    }

}
