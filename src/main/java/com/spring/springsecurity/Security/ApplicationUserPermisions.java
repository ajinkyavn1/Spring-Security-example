package com.spring.springsecurity.Security;

public enum ApplicationUserPermisions {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");
    private final  String permission;

     ApplicationUserPermisions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
