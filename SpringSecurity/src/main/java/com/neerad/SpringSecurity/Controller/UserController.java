package com.neerad.SpringSecurity.Controller;

import com.neerad.SpringSecurity.Services.UserService;
import com.neerad.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users UserRegister(@RequestBody Users users){
        return userService.UserRegister(users);
    }
    @PostMapping("/login")
    public String UserLogin(@RequestBody Users users){
       return userService.verify(users);
    }
}
