package com.messBook.MessBook.Service.MessService;

import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Service.MessService.Models.ItemDTO;
import com.messBook.MessBook.Service.MessService.Models.OrderDTO;
import com.messBook.MessBook.Service.MessService.Models.PastOrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class PastOrders {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ItemDTO> getOrderItemsForOrderId(String orderId) {
        String query = "SELECT name , price FROM OrderItems where order_id = ?";
        List<ItemDTO> items = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ItemDTO.class), orderId);

        return items;
    }

    public List<PastOrdersDTO> getPastOrders(String student_id) {
        List<PastOrdersDTO> pastOrders = new ArrayList<>();

        String query = "SELECT order_id, order_date, resolved_date FROM Orders where student_id = ?";
        List<OrderDTO> orders = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(OrderDTO.class), student_id);

        for(OrderDTO orderDTO : orders) {
            PastOrdersDTO pastOrdersDTO = new PastOrdersDTO();

            pastOrdersDTO.setItems(getOrderItemsForOrderId(orderDTO.getOrder_id()));
            pastOrdersDTO.setMessName(orderDTO.getMess_name());
            pastOrdersDTO.setDateOfOrder(orderDTO.getOrder_date());

            int netTotal = 0;

            for(ItemDTO itemDTO:pastOrdersDTO.getItems()) {
                netTotal += itemDTO.getPrice();
            }

            pastOrdersDTO.setNetTotal(netTotal);

            pastOrders.add(pastOrdersDTO);
        }

        return pastOrders;
    }
}
