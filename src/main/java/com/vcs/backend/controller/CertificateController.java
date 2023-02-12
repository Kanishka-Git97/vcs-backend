package com.vcs.backend.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Certificate;
import com.vcs.backend.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/certificate")
@CrossOrigin
public class CertificateController {
    @Autowired
    private CertificateService service;

    @PostMapping("/add")
    public String add(@RequestBody Certificate certificate){
        return service.apply(certificate);
    }

    @PostMapping("/all")
    public List<Certificate> all(@RequestBody ObjectNode data){
        return service.all(data.get("doctor").asInt());
    }
}
