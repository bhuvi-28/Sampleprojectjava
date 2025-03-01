package org.example.model;

public class User {
    private String name;
    private int age;
    private String birthday;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, int age, String birthday, String email) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getBirthday() { return birthday; }
    public String getEmail() { return email; }
}

