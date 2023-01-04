package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Clinic;
import com.vcs.backend.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicImpl implements ClinicService{
    @Autowired
    private ClinicRepository repository;

    public String save(ObjectNode data){
        Clinic clinic = new Clinic();
        clinic.setName(data.get("name").asText());
        clinic.setAddress(data.get("address").asText());
        clinic.setReg(data.get("reg").asText());
        clinic.setLongitude(data.get("long").asDouble());
        clinic.setLatitude(data.get("lat").asDouble());
        clinic.setDoctor(data.get("doctor").asInt());

        if(repository.validateBusiness(clinic.getReg())> 0){
            return "Business Already Registered Under this Licence";
        }
        if(repository.getClinicCount(clinic.getDoctor()) == 2){
            return "You are reach maximum Clinic Registration";
        }
        repository.save(clinic);
        return "Clinic Saved";
    }

    public List<Clinic> all(){
        return repository.findAll();
    }

    public String delete(int id){
        repository.delete(id);
        return "Deleted";
    }
}
