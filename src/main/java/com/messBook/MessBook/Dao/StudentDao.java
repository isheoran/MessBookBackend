package com.messBook.MessBook.Dao;

import com.messBook.MessBook.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDao(){}

    public Student registerStudent(Student student) {
        String query = "INSERT INTO Student Values(?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(query,new Object[]{student.getId(),student.getUser_name(),student.getRoll_number(),student.getName(),student.getTime_stamp_of_creation(),student.getPassword(),student.getRole()});
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }

        return student;
    }

    public Student getStudent(String user_name) {
        String query = "Select * from Student where user_name = ?";
        List<Student> students = jdbcTemplate.query(query,new BeanPropertyRowMapper<Student>(Student.class),new Object[]{user_name});
        Student student;
        if(students.isEmpty()) student = null;
        else student = students.get(0);

        return student;
    }

    public List<Student> getAllStudents() {
        String query = "Select * from Student";
        List<Student> students = jdbcTemplate.query(query,new BeanPropertyRowMapper<Student>(Student.class));

        return students;
    }
}
