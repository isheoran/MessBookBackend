package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.AdminService;
import com.messBook.MessBook.Service.AuthorizeService;
import com.messBook.MessBook.Service.Models.UserDto;
import com.messBook.MessBook.Service.Models.UserLoginRequest;
import com.messBook.MessBook.Service.Models.UserRegisterRequest;
import com.messBook.MessBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthorizeController {
    @Autowired
    AuthorizeService authorizeService;
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;

    @PostMapping("login")
    public UserDto login(@RequestBody UserLoginRequest userLoginRequest) {
        return authorizeService.login(userLoginRequest);
    }

    @PostMapping("signup")
    public UserDto register(@RequestBody UserRegisterRequest userRegisterRequest) {
        if(userRegisterRequest.getRole().equals("student")) {
            Student student = new Student(userRegisterRequest.getUser_name(),userRegisterRequest.getRoll_number(),userRegisterRequest.getName(),userRegisterRequest.getPassword(),userRegisterRequest.getRole());
            student = studentService.registerStudent(student);
            return new UserDto(student.getUser_name(),student.getName(),student.getRole());
        }
        else {
            Admin admin = new Admin(userRegisterRequest.getUser_name(),userRegisterRequest.getName(),userRegisterRequest.getPassword(),userRegisterRequest.getRole());
            admin = adminService.register(admin);

            return new UserDto(admin.getUser_name(),admin.getName(),admin.getRole());
        }
    }
}
