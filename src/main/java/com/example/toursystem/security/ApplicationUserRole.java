package com.example.toursystem.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.toursystem.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    TOURIST(Sets.newHashSet()),
    HOST(Sets.newHashSet()),
    STAFF(Sets.newHashSet());
//    STUDENT(Sets.newHashSet()),
//    ADMIN(Sets.newHashSet(EMPLOYEE_READ,EMPLOYEE_WRITE,EMPLOYEE_DELETE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
