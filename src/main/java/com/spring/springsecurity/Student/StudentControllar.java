package com.spring.springsecurity.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentControllar {

    public  static final List<Student> studentList= Arrays.asList(
      new Student(1,"Ajinkya Narkhede"),
            new Student(2,"Umesh Chaudhari"),
            new Student(3,"Rahul Chavhan"),
            new Student(4,"Bhavesh Patil"),
            new Student(5,"Yogesh gend")
    );

    @GetMapping(path = "{StudentId}")
    public Student getStudent(@PathVariable("StudentId") Integer id){
            return  studentList.stream()
                    .filter(student -> id.equals(student.getStudentId()))
                    .findFirst()
                    .orElseThrow(()->new IllegalStateException("Student "+id+" Does Not Exits."));
    }

}
