package org.example.controller;

import org.example.model.User;
import org.example.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.dao.UserDAO;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserDAO userDAO;

    // Constructor Injection (Recommended for Spring Beans)
    public UserController() {
        this.userDAO = new UserDAO(); // Create an instance of UserDAO
    }
    
    @GetMapping("/{email}")
    public UserProfile getUserProfile(@PathVariable String email) {
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            List<User> friends = userDAO.getFriends(user.getId());
            return new UserProfile(user, friends);
        }
        return null;
    }
}
