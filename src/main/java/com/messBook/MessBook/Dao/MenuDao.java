package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MenuDao() {}

    public boolean saveMenu(Menu menu) {
        String query = "INSERT INTO Menu (id, name, price, mess_id) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(query, menu.getId(), menu.getName(), menu.getPrice(), menu.getMess_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public Menu getMenuById(String id) {
        String query = "SELECT * FROM Menu WHERE id = ?";
        List<Menu> menus = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Menu.class), id);
        return menus.isEmpty() ? null : menus.get(0);
    }
}
