package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Service.MessListService.MessListService;
import com.messBook.MessBook.Service.MessListService.Models.MessDTO;
import com.messBook.MessBook.Service.MessService.OrdersService;
import com.messBook.MessBook.Service.Models.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MessController {
    @Autowired
    private MessListService messListService;
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/messlist")
    public List<MessDTO> getMessList() {
        return messListService.messList();
    }

    @PostMapping("/submitorder")
    public boolean submitOrder(@RequestBody OrdersRequest ordersRequest) {
        return ordersService.addOrder(ordersRequest);
    }
}
