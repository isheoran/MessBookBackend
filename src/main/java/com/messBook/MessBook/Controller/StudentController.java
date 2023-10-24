package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Entities.Student;
import com.messBook.MessBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("student/get/{username}")
    public ResponseEntity<Student> getStudent(@PathVariable String username) {
        try {
            return new ResponseEntity<>(studentService.getStudent(username), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("student/listofstudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(""+e);

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
