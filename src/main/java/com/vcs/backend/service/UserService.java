package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Sender;

public interface UserService {
    public Sender validateLogin(String username, String password);
    public String register(ObjectNode data);

}
