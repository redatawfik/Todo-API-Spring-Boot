package com.example.todo.controller;

import com.example.todo.entity.ApplicationUser;
import com.example.todo.repository.ApplicationUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody ApplicationUser user) {
        if(user.getPassword().length() < 7 ||
        !user.getPassword().equals(user.getConfirmPassword())){
            return ResponseEntity.badRequest().build();
        }
        if(applicationUserRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
        return ResponseEntity.ok("Successful sign in!");
    }
}