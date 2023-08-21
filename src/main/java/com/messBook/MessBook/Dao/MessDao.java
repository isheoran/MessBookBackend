package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.Mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MessDao() {}

    public boolean saveMess(Mess mess) {
        String query = "INSERT INTO Mess (id, name) VALUES (?, ?)";

        try {
            jdbcTemplate.update(query, mess.getId(), mess.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public Mess getMessById(String id) {
        String query = "SELECT * FROM Mess WHERE id = ?";
        List<Mess> messes = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Mess.class), id);
        return messes.isEmpty() ? null : messes.get(0);
    }

}
