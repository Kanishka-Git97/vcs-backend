package com.vcs.backend.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.*;
import com.vcs.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Objects;


@Service
public class UserImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private ClientRepository clientRepository;

    //    Login Validation
    public Sender validateLogin(String username, String password){
        Sender sender = new Sender();
        if(repository.validateUser(username, password) > 0){
            //Get User
            sender.msg = "Success";
            User user = repository.loggedUser(username, password);

            if(Objects.equals(user.getLevel(), "Doctor")){
                sender.data = doctorRepository.findById(user.getUser()).orElse(null);
            }
            if(Objects.equals(user.getLevel(), "Client")){
                sender.data = clientRepository.findById(user.getUser()).orElse(null);
            }

        }
        else{
            sender.msg = "Unauthorized Access";
        }
        return  sender;
    }

    //User Registration
    public String register(ObjectNode data){
        if(Objects.equals(data.get("level").asText(),"Doctor")) {
            Doctor doctor = new Doctor();
            doctor.setFirstName(data.get("firstName").asText());
            doctor.setLastName(data.get("lastName").asText());
            doctor.setNic(data.get("nic").asText());
            doctor.setAddress(data.get("homeAddress").asText());
            doctor.setMobile(data.get("mobileNumber").asText());
            doctor.setEmail(data.get("email").asText());
            doctor.setOnlineFee(data.get("onlineRate").asDouble());
            doctor.setPhysicalFee(data.get("physicalRate").asDouble());
            doctor.setTitle(data.get("title").asText());
            doctor.setStatus("Pending");
            doctor.setImg(data.get("img").asText());

            Doctor savedDoctor = doctorRepository.save(doctor);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode listRoot = data.get("educationalInfo");
            List<ObjectNode> educations = mapper.convertValue(listRoot, new TypeReference<List<ObjectNode>>() {
            });


            for(int i = 0; i < educations.size(); i++){
                Education education = new Education();
                education.setSchool(educations.get(i).get("institute").asText());
                education.setDegree(educations.get(i).get("degree").asText());
                education.setYear(educations.get(i).get("year").asText());
                education.setDoctor(savedDoctor.getId());

                educationRepository.save(education);
            }

            Clinic clinic = new Clinic();
            clinic.setName(data.get("business").asText());
            clinic.setReg(data.get("reg").asText());
            clinic.setLatitude(data.get("lat").asDouble());
            clinic.setLongitude(data.get("long").asDouble());
            clinic.setAddress(data.get("address").asText());
            clinic.setDoctor(savedDoctor.getId());

            clinicRepository.save(clinic);

            // Update Login Details
            User user = new User();
            user.setUsername(savedDoctor.getEmail());
            user.setUser(savedDoctor.getId());
            user.setPassword(data.get("password").asText());
            user.setLevel(data.get("level").asText());

            repository.save(user);
        }


//        if(Objects.equals(data.get("level"), "Doctor")){
//            Doctor doctor = new Doctor();
//            doctor.setFirstName(data.get("firstName").asText());
//            doctor.setLastName(data.get("lastName").asText());
//            doctor.setNic(data.get("nic").asText());
//            doctor.setAddress(data.get("homeAddress").asText());
//            doctor.setMobile(data.get("mobileNumber").asText());
//            doctor.setEmail(data.get("email").asText());
//            doctor.setOnlineFee(data.get("onlineRate").asDouble());
//            doctor.setPhysicalFee(data.get("physicalRate").asDouble());
//            doctor.setTitle(data.get("title").asText());
//            doctor.setStatus("Pending");
//
//            Doctor savedDoctor = doctorRepository.save(doctor);
//
//            // Update Login Details
//            User user = new User();
//            user.setUsername(savedDoctor.getEmail());
//            user.setPassword(data.get("password").asText());
//            user.setLevel(data.get("level").asText());
//
//            repository.save(user);
//        }
//        if(data.get("level").asText() == "Client"){
//
//        }
//        User user = new User();
//        Doctor doctor = new Doctor();
//        user.setPassword(data.get("password").asText());
//        user.setUsername(data.get("email").asText());
//        user.setLevel(data.get("level").asText());
//        //User Registration
//        if(repository.validateUser(data.get("email").asText(), data.get("password").asText())>0){
//            return "Already Registered Please Login!";
//        }
//        User savedUser = repository.save(user);
//        //Profile Registration
//        if(Objects.equals(savedUser.getLevel(), "Doctor")){
//            doctor.setFirstName(data.get("firstName").asText());
//            doctor.setLastName(data.get("lastName").asText());
//            doctor.setEmail(data.get("email").asText());
//            doctor.setAddress(data.get("address").asText());
//            doctor.setMobile(data.get("mobile").asText());
//            doctor.setTitle(data.get("title").asText());
//            doctor.setOnlineFee(data.get("fee").asDouble());
//            doctor.setStatus("Pending");
//
//
//            doctorRepository.save(doctor);
//        }
//        if(Objects.equals(savedUser.getLevel(), "Client")){
//
//        }
        return "Success";
    }
}
