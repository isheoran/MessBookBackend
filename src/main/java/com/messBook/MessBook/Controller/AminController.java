package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Menu;
import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Service.AdminService;
import com.messBook.MessBook.Service.MessService.PastOrders;
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
public class AminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PastOrders pastOrders;

    @GetMapping("/admin/listofadmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/admin/createmess")
    public Mess createMess(@RequestBody String messName) {
        return adminService.createMess(messName);
    }

    @PostMapping("admin/addmenuitem")
    public Menu addMenuItem(@RequestBody Menu menu) {
        return adminService.addMenuItem(menu);
    }

    @GetMapping("admin/resolveOrders/{student_id}")
    public int resolvedOrders(@PathVariable String student_id) {
        return pastOrders.resolveOrders(student_id);
    }
}
