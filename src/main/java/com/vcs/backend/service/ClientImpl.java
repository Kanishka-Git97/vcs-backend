package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Client;
import com.vcs.backend.model.User;
import com.vcs.backend.repository.ClientRepository;
import com.vcs.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientImpl implements ClientService{
    @Autowired
    private ClientRepository repository;
    @Autowired
    private UserRepository userRepository;

    public String register(ObjectNode data){
        Client client = new Client();
        client.setFirstName(data.get("firstName").asText());
        client.setLastName(data.get("lastName").asText());
        client.setAddress(data.get("address").asText());
        client.setEmail(data.get("email").asText());
        client.setMobile(data.get("mobile").asText());
        client.setLongitude(data.get("longitude").asDouble());
        client.setLatitude(data.get("latitude").asDouble());
        client.setRegisterVia(data.get("registerVia").asText());
        client.setImg(data.get("img").asText());

        Client savedClient = repository.save(client);

        if(Objects.equals(client.getRegisterVia(), "Doctor")){
            client.setReferral(data.get("referral").asInt());
        }
        else{
            User user = new User();
            user.setLevel("Client");
            user.setUsername(data.get("email").asText());
            user.setPassword(data.get("password").asText());
            user.setUser(savedClient.getId());
            User savedUser = userRepository.save(user);
            client.setUser(savedUser.getId());
        }
        return "Registration Successful!";
    }

    public List<Client> all(){
        return  repository.findAll();
    }

    @Override
    public Client get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getByDoctor(Integer doctor) {
        return repository.getByDoctor(doctor);
    }

    @Override
    public String update(Client client) {
        repository.save(client);
        return "True";
    }
}
