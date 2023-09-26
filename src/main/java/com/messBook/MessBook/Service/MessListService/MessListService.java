package com.messBook.MessBook.Service.MessListService;

import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Service.MessListService.Models.MessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessListService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MessDTO> messList() {
        String query = "SELECT * FROM Mess";
        List<Mess> messes = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Mess.class));
        List<MessDTO> messDTOS = new ArrayList<>();
        for(Mess mess : messes) {
            MessDTO messDTO = new MessDTO();
            messDTO.setMessID(mess.getId());
            messDTO.setMessName(mess.getName());
            messDTO.setMessMenuItemCount(getCountOfMessItems(mess.getId()));
            messDTOS.add(messDTO);
        }

        return messDTOS;
    }

    public int getCountOfMessItems(String mess_id) {
        String query = "SELECT COUNT(*) AS menu_count FROM Menu WHERE mess_id = ?";
        int menuCount = jdbcTemplate.queryForObject(query, Integer.class, mess_id);
        return menuCount;
    }
}
