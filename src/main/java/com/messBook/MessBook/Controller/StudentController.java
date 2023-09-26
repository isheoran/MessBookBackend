package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("student/get/{username}")
    public Student getStudent(@PathVariable String username) {
        return studentService.getStudent(username);
    }

    @GetMapping("student/listofstudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
