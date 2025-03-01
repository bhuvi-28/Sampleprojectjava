package org.example.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.example.model.*;;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        String sql = "SELECT name, age, birthday, email FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(rs.getString("name"), rs.getInt("age"),
                        rs.getString("birthday"), rs.getString("email")));
    }
}
