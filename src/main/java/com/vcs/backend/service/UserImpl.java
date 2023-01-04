package com.vcs.backend.service;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Doctor;
import com.vcs.backend.model.Sender;
import com.vcs.backend.model.User;
import com.vcs.backend.repository.DoctorRepository;
import com.vcs.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private DoctorRepository doctorRepository;

    //    Login Validation
    public Sender validateLogin(String username, String password){
        Sender sender = new Sender();
        if(repository.validateUser(username, password) > 0){
            //Get User
            sender.msg = "Success";
            User user = repository.loggedUser(username, password);

            if(Objects.equals(user.getLevel(), "Doctor")){
                sender.data = doctorRepository.getLoginDoctor(user.getId());
            }
            else {
                sender.data = user;
            }
        }
        else{
            sender.msg = "Unauthorized Access";
        }
        return  sender;
    }

    //User Registration
    public String register(ObjectNode data){
        User user = new User();
        Doctor doctor = new Doctor();
        user.setPassword(data.get("password").asText());
        user.setUsername(data.get("email").asText());
        user.setLevel(data.get("level").asText());
        //User Registration
        if(repository.validateUser(data.get("email").asText(), data.get("password").asText())>0){
            return "Already Registered Please Login!";
        }
        User savedUser = repository.save(user);
        //Profile Registration
        if(Objects.equals(savedUser.getLevel(), "Doctor")){
            doctor.setFirstName(data.get("firstName").asText());
            doctor.setLastName(data.get("lastName").asText());
            doctor.setEmail(data.get("email").asText());
            doctor.setAddress(data.get("address").asText());
            doctor.setMobile(data.get("mobile").asText());
            doctor.setTitle(data.get("title").asText());
            doctor.setFee(data.get("fee").asDouble());
            doctor.setStatus("Pending");
            doctor.setUserRef(savedUser.getId());

            doctorRepository.save(doctor);
        }
        if(Objects.equals(savedUser.getLevel(), "Client")){

        }
        return "Successfully Registered!";
    }
}
