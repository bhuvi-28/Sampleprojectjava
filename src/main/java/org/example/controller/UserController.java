package org.example.controller;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
 @CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
