package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Service.MessListService.MessListService;
import com.messBook.MessBook.Service.MessListService.Models.MessDTO;
import com.messBook.MessBook.Service.MessService.Models.PastOrdersDTO;
import com.messBook.MessBook.Service.MessService.OrdersService;
import com.messBook.MessBook.Service.MessService.PastOrders;
import com.messBook.MessBook.Service.Models.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MessDTO>> getMessList() {
        try {
            return new ResponseEntity<>(messListService.messList(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/submitOrder")
    public ResponseEntity<? extends Object> submitOrder(@RequestBody OrdersRequest ordersRequest) {
        try {
            return new ResponseEntity<>(ordersService.addOrder(ordersRequest), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/pastOrders/{student_id}")
    public ResponseEntity<List<PastOrdersDTO>> getPastOrders(@PathVariable String student_id) {
        try {
            return new ResponseEntity<>(pastOrders.getPastOrders(student_id), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/pastResolvedOrders/{student_id}")
    public ResponseEntity<List<PastOrdersDTO>> getPastResolvedOrders(@PathVariable String student_id) {
        try {
            return new ResponseEntity<>(pastOrders.getPastResolvedOrders(student_id), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/pastUnResolvedOrders/{student_id}")
    public ResponseEntity<List<PastOrdersDTO>> getPastUnResolvedOrders(@PathVariable String student_id) {
        try {
            return new ResponseEntity<>(pastOrders.getPastUnResolvedOrders(student_id), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
