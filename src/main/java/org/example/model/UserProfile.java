package org.example.model;

import java.util.List;

public class UserProfile {
    private User user;
    private List<User> friends;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public UserProfile(User user, List<User> friends) {
        this.user = user;
        this.friends = friends;
    }

}
