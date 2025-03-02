package org.example.model;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String name, int age, Date birthday, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
    }

    // Getters & Setters
}