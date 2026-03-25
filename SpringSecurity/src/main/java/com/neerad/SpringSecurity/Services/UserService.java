package com.neerad.SpringSecurity.Services;

import com.neerad.SpringSecurity.model.Users;
import com.neerad.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public Users UserRegister(Users users){
      users.setPassword(encoder.encode(users.getPassword()));
       return userRepo.save(users);
  }
  public String verify(Users users){
      Authentication  authentication =
              authManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
              if(authentication.isAuthenticated()){
                 // returns true or false
                 return jwtService.generateToken(users.getUsername());
              }
              else{
                  return "Fail";
              }
              }
  }

