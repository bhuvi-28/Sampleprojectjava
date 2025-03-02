package org.example.dao;

import org.example.model.User;
import org.example.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

//    public List<User> getUsers() {
//        User user = null;
//        try (Connection conn = DatabaseConfig.getConnection()) {
//            String sql = "SELECT name, age, birthday, email FROM users";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                user = new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getInt("age"),
//                        rs.getDate("birthday"),
//                        rs.getString("email")
//                );
//            }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//        return (List<User>) user;
//    }

    public User getUserByEmail(String email) {
        User user = null;
        try (Connection conn = DatabaseConfig.getConnection()) {  // Calls static method
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDate("birthday"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getFriends(int userId) {
        List<User> friends = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection()) {
            String sql = "SELECT u.* FROM users u JOIN friends f ON u.id = f.friend_id WHERE f.user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                friends.add(new User(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getDate("birthday"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends;
    }
}
