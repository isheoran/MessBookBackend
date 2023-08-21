package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDao() {}

    public boolean saveOrder(Order order) {
        String query = "INSERT INTO Orders (order_id, student_id, mess_name, order_date, resolved_date) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(query, order.getOrder_id(), order.getStudent_id(), order.getOrder_date(), order.getResolved_date());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public Order getOrderById(String orderId) {
        String query = "SELECT * FROM Orders WHERE order_id = ?";
        List<Order> orders = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Order.class), orderId);
        return orders.isEmpty() ? null : orders.get(0);
    }
}
