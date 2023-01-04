package com.vcs.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserRef(int userRef) {
        this.userRef = userRef;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String mobile;
    private String title;
    private double fee;
    private String status;
    private int userRef;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTitle() {
        return title;
    }

    public double getFee() {
        return fee;
    }

    public String getStatus() {
        return status;
    }

    public int getUserRef() {
        return userRef;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}