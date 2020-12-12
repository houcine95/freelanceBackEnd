package com.fennec.freelanceproject.controller;

import com.fennec.freelanceproject.model.AppUser;
import com.fennec.freelanceproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class UserController {



    @Autowired
    private AccountService accountService;

    @GetMapping("/hi")
    public String hi(){
        return "Hi from API";
    }

    @PostMapping("/users")
    public AppUser signUp(@RequestBody RegistrationForm data) throws Exception {
        String username = data.getUsername();
        String password = data.getPassword();
        String role = data.getRole();
        AppUser u = accountService.findUserByUsername(username);
        if(u != null) throw new Exception("This user already exists, try again");
        if(role == "ADMIN") throw new Exception("This role is not allowed while subscription, try again");
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(password);
        accountService.saveUser(user);
        accountService.addRoleToUser(username, role);
        return user;
    }

}
