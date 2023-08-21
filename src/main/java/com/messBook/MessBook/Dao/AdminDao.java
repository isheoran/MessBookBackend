package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdminDao() {}

    public Admin saveAdmin(Admin admin) {
        String query = "INSERT INTO Admin (id, user_name, name, time_stamp_of_creation, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(query, admin.getId(), admin.getUser_name(), admin.getName(),
                    admin.getTime_stamp_of_creation(), admin.getPassword(), admin.getRole());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return admin;
    }

    public Admin getAdminByUsername(String userName) {
        String query = "SELECT * FROM Admin WHERE user_name = ?";
        List<Admin> admins = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Admin.class), userName);
        return admins.isEmpty() ? null : admins.get(0);
    }
}
