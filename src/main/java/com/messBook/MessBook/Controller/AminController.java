package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Menu;
import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Service.AdminService;
import com.messBook.MessBook.Service.MessService.PastOrders;
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
public class AminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PastOrders pastOrders;

    @GetMapping("/admin/listofadmins")
    public ResponseEntity<List<Admin>> getAllAdmins() {

        try {
            return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/admin/createmess")
    public ResponseEntity<Mess> createMess(@RequestBody String messName) {
        try {
            return new ResponseEntity<>(adminService.createMess(messName), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("admin/addmenuitem")
    public ResponseEntity<Menu> addMenuItem(@RequestBody Menu menu) {
        try {
            return new ResponseEntity<>(adminService.addMenuItem(menu), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("admin/resolveOrders/{student_id}")
    public ResponseEntity<Integer> resolvedOrders(@PathVariable String student_id) {
        try {
            return new ResponseEntity<>(pastOrders.resolveOrders(student_id), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
