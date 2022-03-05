package com.example.toursystem.auth;

import com.example.toursystem.model.User;
import com.example.toursystem.service.UserServices;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.toursystem.security.ApplicationUserRole.*;

@Repository("db")
public class UserRepository implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    private final UserServices userServices;

    @Autowired
    public UserRepository(PasswordEncoder passwordEncoder, UserServices userServices) {
        this.passwordEncoder = passwordEncoder;
        this.userServices = userServices;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        User user = userServices.findByUsername(username);
        System.out.println("User found: " + user);
        Set<SimpleGrantedAuthority> grantedAuthorities = null;
        String userRole = user.getRole();
        System.out.println("Role: "+userRole);
        System.out.println("Check: "+(userRole == "ROLE_STAFF"));
        switch (userRole){
            case "ROLE_STAFF":
                grantedAuthorities = STAFF.getGrantedAuthorities();
                break;
            case "ROLE_TOURIST":
                grantedAuthorities = TOURIST.getGrantedAuthorities();
                break;
            case "ROLE_HOST":
                grantedAuthorities = HOST.getGrantedAuthorities();
                break;

        }
        Optional<ApplicationUser> applicationUser = Optional.of(new ApplicationUser(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities,
                true,
                true,
                true,
                true
        ));

        return applicationUser;
    }

//    private List<ApplicationUser> getApplicationUsers() {
//        List<ApplicationUser> applicationUsers = Lists.newArrayList(
//                new ApplicationUser(
//                        "johnny",
//                        passwordEncoder.encode("johnny"),
//                        STAFF.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//        );
//
//        return applicationUsers;
//    }
}
