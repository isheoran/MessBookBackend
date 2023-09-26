package com.messBook.MessBook.Service;

import com.messBook.MessBook.Dao.AdminDao;
import com.messBook.MessBook.Dao.MenuDao;
import com.messBook.MessBook.Dao.MessDao;
import com.messBook.MessBook.Entities.Admin;
import com.messBook.MessBook.Entities.Menu;
import com.messBook.MessBook.Entities.Mess;
import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.Models.UserDto;
import com.messBook.MessBook.Service.Models.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private MessDao messDao;

    @Autowired
    private MenuDao menuDao;

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

    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    public Mess createMess(String messName) {
        Mess mess = new Mess(messName);

        if(messDao.saveMess(mess)) {
            return mess;
        }
        else {
            return null;
        }
    }

    public Menu addMenuItem(Menu menu) {
        menu = new Menu(menu.getName(),menu.getPrice(),menu.getMess_id());

        if(menuDao.saveMenu(menu)) {
            return menu;
        }
        else {
            return null;
        }
    }
}
