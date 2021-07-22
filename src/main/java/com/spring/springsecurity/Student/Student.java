package com.spring.springsecurity.Student;

public class Student {
    final Integer studentid;
    final String studentName;
    final String password;


    public Student(Integer studentid, String studentName, String password) {
        this.studentid = studentid;
        this.studentName = studentName;
        this.password = password;
    }
    public  Integer getStudentId(){
        return  studentid;
    }

    public  String getStudentName(){
        return  studentName;
    }

    public String getPassword() {
        return password;
    }
}
