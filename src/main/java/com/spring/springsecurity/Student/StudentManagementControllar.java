package com.spring.springsecurity.Student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students/")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentManagementControllar {
    public  static final List<Student> studentList= Arrays.asList(
            new Student(1,"Ajinkya Narkhede","Ajinkya" ),
            new Student(2,"Umesh Chaudhari", "Ajinkya" ),
            new Student(3,"Rahul Chavhan", "Ajinkya" ),
            new Student(4,"Bhavesh Patil","Ajinkya" ),
            new Student(5,"Yogesh gend", "Ajinkya")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return studentList;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.printf("%s %s%n", studentId, student);
    }
}
