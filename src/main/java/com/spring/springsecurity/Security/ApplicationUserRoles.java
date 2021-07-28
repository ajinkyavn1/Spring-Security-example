package com.spring.springsecurity.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.springsecurity.Security.ApplicationUserPermisions.*;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    SUPERADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));
    private  final Set<ApplicationUserPermisions> permisions;

    ApplicationUserRoles(Set<ApplicationUserPermisions> permisions) {
        this.permisions = permisions;
    }

    public Set<ApplicationUserPermisions> getPermisions() {
        return permisions;
    }
    public  Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions= getPermisions().stream()
                .map(permisions->new SimpleGrantedAuthority(permisions.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE"+this.name()));
        return  permissions;
    }
}
