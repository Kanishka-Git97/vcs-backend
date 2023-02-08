package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Appointment;
import com.vcs.backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository repository;

    public String apply(ObjectNode data){
        Appointment appointment = new Appointment();
        appointment.setDate(data.get("date").asText());
        appointment.setTime(data.get("time").asText());
        appointment.setDoctor(data.get("doctor").asInt());
        appointment.setClient(data.get("client").asInt());
        appointment.setStatus(data.get("status").asText());
        appointment.setType(data.get("type").asText());
        appointment.setClinic(data.get("clinic").asInt());

        if(repository.validate(appointment.getDate(), appointment.getTime(), appointment.getDoctor()) > 0){
            return "Time Slot are Already Reserved";
        }
        else{
            repository.save(appointment);
            return "Successfully Applied";
        }

    }

    public List<Appointment> all(){
        return repository.findAll();
    }

    @Override
    public List<Appointment> getAppointments(Integer doctor) {
        return repository.getAllByDoctor(doctor);
    }
}
