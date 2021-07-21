package com.spring.springsecurity.Security;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

import static com.spring.springsecurity.Security.ApplicationUserPermisions.*;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));
    private  final Set<ApplicationUserPermisions> permisions;

    ApplicationUserRoles(Set<ApplicationUserPermisions> permisions) {
        this.permisions = permisions;
    }

    public Set<ApplicationUserPermisions> getPermisions() {
        return permisions;
    }
}
