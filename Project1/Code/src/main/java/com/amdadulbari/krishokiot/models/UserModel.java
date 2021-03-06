package com.amdadulbari.krishokiot.models;


import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Repository
@Entity
public class UserModel {
    @Id
    public String name;
    public int age;
    public String phoneNumber;
    public String address;
    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
