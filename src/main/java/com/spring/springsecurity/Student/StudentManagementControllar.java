package com.spring.springsecurity.Student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementControllar {
    public  static final List<Student> studentList= Arrays.asList(
            new Student(1,"Ajinkya Narkhede","Ajinkya" ),
            new Student(2,"Umesh Chaudhari", "Ajinkya" ),
            new Student(3,"Rahul Chavhan", "Ajinkya" ),
            new Student(4,"Bhavesh Patil","Ajinkya" ),
            new Student(5,"Yogesh gend", "Ajinkya")
    );
    @GetMapping
    public  List<Student> getAllStudent(){
        return  studentList;
    }
    @PostMapping
    public void  RegisterNewUser(@RequestBody  Student student){
        System.out.println(student);
    }
    @DeleteMapping(path = "{id}")
    public  void deleteStudent(@PathVariable()  Integer id){
        System.out.println(id);
    }
    @PutMapping(path = "{id}")
    public  void UpdateStudent(@PathVariable Integer id,@RequestBody  Student student){
        System.out.println(String.format("%s%s",id,student));
    }
}
