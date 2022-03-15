package com.example.toursystem.controller.api;

import com.example.toursystem.entity.ApproveStatus;
import com.example.toursystem.entity.User;
import com.example.toursystem.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    private UserServices userServices;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAPIController(UserServices userServices, PasswordEncoder passwordEncoder) {
        this.userServices = userServices;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/find")
    public List<User> getAllUsers(){
        return userServices.findAll();
    }

    @GetMapping("/find/{username}")
    public User findUser(@PathVariable String username){
        User user = userServices.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found -  " + username);
        }
        return user;
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        try {
            User userFromQuery = userServices.findByID(user.getId());

            userFromQuery.setEmail(user.getEmail());
            userFromQuery.setFullName(user.getFullName());
            userFromQuery.setNationality(user.getNationality());
            userFromQuery.setHomeAddress(user.getHomeAddress());
            userFromQuery.setBankAccountNumber(user.getBankAccountNumber());

            userServices.save(userFromQuery);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }

    @PostMapping("/newUser")
    public String saveUser(@RequestBody User user){
        user.setId(0);
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        userServices.save(user);
        return "Done";
    }

    @PostMapping("/newUserList")
    public String saveUserList(@RequestBody List<User> users){
        for (User user:users){
            user.setId(0);
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);

            userServices.save(user);
        }

        return "Done";
    }


    @PostMapping("/hostApprove/{id}")
    public String changeHostStatus(@PathVariable int id, @RequestParam String newStatus){
        try {
            User user = userServices.findByID(id);
            ApproveStatus newApproveStatus = ApproveStatus.valueOf(newStatus);
            user.setHostApproveStatus(newApproveStatus);
            userServices.save(user);
        }catch (Exception e){
            return e.getMessage();
        }
        return "success";
    }
}
