package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Appointment;

import java.util.List;

public interface AppointmentService {
    public String apply(ObjectNode data);
    public List<Appointment> all();
}
