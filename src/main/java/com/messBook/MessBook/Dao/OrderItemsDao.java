package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderItemsDao() {}

    public boolean saveOrderItem(OrderItems orderItem) {
        String query = "INSERT INTO OrderItems (id, order_id, name, price) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(query, orderItem.getId(), orderItem.getOrder_id(), orderItem.getName(), orderItem.getPrice());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public List<OrderItems> getOrderItemsByOrderId(String orderId) {
        String query = "SELECT * FROM OrderItems WHERE order_id = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(OrderItems.class), orderId);
    }
}
