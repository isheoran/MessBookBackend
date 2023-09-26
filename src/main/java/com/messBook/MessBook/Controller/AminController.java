package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Menu;
import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AminController {
    @Autowired
    private AdminService adminService;

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
}
