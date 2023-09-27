package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Service.MessListService.MessListService;
import com.messBook.MessBook.Service.MessListService.Models.MessDTO;
import com.messBook.MessBook.Service.MessService.Models.PastOrdersDTO;
import com.messBook.MessBook.Service.MessService.OrdersService;
import com.messBook.MessBook.Service.MessService.PastOrders;
import com.messBook.MessBook.Service.Models.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private PastOrders pastOrders;

    @GetMapping("/messList")
    public List<MessDTO> getMessList() {
        return messListService.messList();
    }

    @PostMapping("/submitOrder")
    public boolean submitOrder(@RequestBody OrdersRequest ordersRequest) {
        return ordersService.addOrder(ordersRequest);
    }

    @GetMapping("/pastOrders/{student_id}")
    public List<PastOrdersDTO> getPastOrders(@PathVariable String student_id) {
        return pastOrders.getPastOrders(student_id);
    }

    @GetMapping("/pastResolvedOrders/{student_id}")
    public List<PastOrdersDTO> getPastResolvedOrders(@PathVariable String student_id) {
        return pastOrders.getPastResolvedOrders(student_id);
    }

    @GetMapping("/pastUnResolvedOrders/{student_id}")
    public List<PastOrdersDTO> getPastUnResolvedOrders(@PathVariable String student_id) {
        return pastOrders.getPastUnResolvedOrders(student_id);
    }
}
