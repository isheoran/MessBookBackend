package com.messBook.MessBook.Service;

import com.messBook.MessBook.Dao.AdminDao;
import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.Models.UserDto;
import com.messBook.MessBook.Service.Models.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AdminDao adminDao;

    @Autowired
    StudentService studentService;

    public UserDto login(UserLoginRequest userLoginRequest) {
        Admin adminDetails = adminDao.getAdminByUsername(userLoginRequest.getUser_name());

        if(adminDetails!=null && adminDetails.getPassword().equals(userLoginRequest.getPassword())) {
            return new UserDto(adminDetails.getUser_name(),adminDetails.getName(),adminDetails.getRole());
        }

        return studentService.login(userLoginRequest);
    }
}
