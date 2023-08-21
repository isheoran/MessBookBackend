package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AminController {
    @Autowired
    AdminService adminService;


}
