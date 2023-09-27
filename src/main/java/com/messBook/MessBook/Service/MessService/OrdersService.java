package com.messBook.MessBook.Service.MessService;

import com.messBook.MessBook.Dao.MenuDao;
import com.messBook.MessBook.Dao.MessDao;
import com.messBook.MessBook.Dao.OrderDao;
import com.messBook.MessBook.Dao.OrderItemsDao;
import com.messBook.MessBook.Entities.Menu;
import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Entities.Order;
import com.messBook.MessBook.Entities.OrderItems;
import com.messBook.MessBook.Service.Models.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MessDao messDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private OrderItemsDao orderItemsDao;

    public List<Menu> messItems(String mess_id) {
        String query = "SELECT * from Menu where mess_id = ?";
        List<Menu> items = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Menu.class),mess_id);

        return items;
    }

    public boolean addOrder(OrdersRequest ordersRequest) {
        Mess mess = messDao.getMessById(ordersRequest.getMess_id());
        Order order = new Order(ordersRequest.getStudent_id(),mess.getName());

        orderDao.saveOrder(order);

        for(String itemId : ordersRequest.getMenuItemsIds()) {
            Menu menu = menuDao.getMenuById(itemId);

            OrderItems orderItems = new OrderItems(order.getOrder_id(),menu.getName(),menu.getPrice());

            orderItemsDao.saveOrderItem(orderItems);
        }

        return true;
    }
}
