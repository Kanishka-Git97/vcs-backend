package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Appointment;
import com.vcs.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping("/apply")
    public String apply(@RequestBody ObjectNode data){
        return service.apply(data);
    }

    @GetMapping("/all")
    public List<Appointment> all(){
        return service.all();
    }
}
