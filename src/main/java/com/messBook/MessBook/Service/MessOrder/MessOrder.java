package com.messBook.MessBook.Service.MessOrder;

import com.messBook.MessBook.Service.MessOrder.Models.MessItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MessOrder {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MessItemDTO> getMessMenuItems(String mess_id) {
        String query = "SELECT id, name FROM Menu where mess_id = ?";
        List<MessItemDTO> messItemDTOS = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MessItemDTO.class), mess_id);

        return messItemDTOS;
    }
}
