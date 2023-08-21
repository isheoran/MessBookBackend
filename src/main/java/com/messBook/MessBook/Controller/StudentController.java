package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("student/signup")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("student/get/{username}")
    public Student getStudent(@PathVariable String username) {
        return studentService.getStudent(username);
    }
}
