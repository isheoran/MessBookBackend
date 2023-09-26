package com.messBook.MessBook.Service;

import com.messBook.MessBook.Dao.StudentDao;
import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.Models.UserDto;
import com.messBook.MessBook.Service.Models.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public StudentService(){};

    public Student registerStudent(Student student) {
        return studentDao.registerStudent(student);
    }

    public Student getStudent(String user_name) {
        return studentDao.getStudent(user_name);
    }

    public UserDto login(UserLoginRequest student) {
        Student studentDetails = getStudent(student.getUser_name());

        if(studentDetails!=null && studentDetails.getPassword().equals(student.getPassword())) {
            return new UserDto(studentDetails.getUser_name(),studentDetails.getName(),studentDetails.getRole());
        }
        else {
            return null;
        }
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
