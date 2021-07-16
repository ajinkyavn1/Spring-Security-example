package com.spring.springsecurity.Student;

public class Student {
    final Integer studentid;
    final String studentName;


    public Student(Integer studentid, String studentName) {
        this.studentid = studentid;
        this.studentName = studentName;
    }
    public  Integer getStudentId(){
        return  studentid;
    }

    public  String getStudentName(){
        return  studentName;
    }
}
