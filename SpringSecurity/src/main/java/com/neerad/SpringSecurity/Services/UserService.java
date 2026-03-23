package com.neerad.SpringSecurity.Services;

import com.neerad.SpringSecurity.model.Users;
import com.neerad.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public Users UserRegister(Users users){
      users.setPassword(encoder.encode(users.getPassword()));
       return userRepo.save(users);
  }
}
