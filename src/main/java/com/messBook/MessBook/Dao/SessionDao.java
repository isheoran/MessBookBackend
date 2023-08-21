package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public SessionDao(){}

    public boolean createSession(UserSession userSession) {
        String query = "INSERT INTO UserSession(id , role, duration) VALUES(? , ?, ?)";

        try {
            jdbcTemplate.update(query,userSession.getId(),userSession.getRole(),userSession.getDuration());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }

        return true;
    }

    public String getRole(String session_id) {
        String query = "SELECT role from UserSession where id = ?";

        try {
            return jdbcTemplate.queryForObject(query, String.class, session_id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
