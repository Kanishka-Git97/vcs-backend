package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Client;

import java.util.List;

public interface ClientService {
    public String register(ObjectNode data);
    public List<Client> all();
    public Client get(int id);
    public List<Client> getByDoctor(Integer doctor);
}
