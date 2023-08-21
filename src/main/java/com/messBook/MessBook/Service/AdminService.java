package com.messBook.MessBook.Service;

import com.messBook.MessBook.Dao.AdminDao;
import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.Models.UserDto;
import com.messBook.MessBook.Service.Models.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public AdminService(){}

    public UserDto login(UserLoginRequest admin) {
        Admin adminDetails = adminDao.getAdminByUsername(admin.getUser_name());

        if(adminDetails!=null && adminDetails.getPassword().equals(admin.getPassword())) {
            return new UserDto(adminDetails.getUser_name(),adminDetails.getName(),adminDetails.getRole());
        }
        else {
            return null;
        }
    }

    public Admin register(Admin admin) {
        return adminDao.saveAdmin(admin);
    }
}
