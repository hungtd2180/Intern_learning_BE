package com.example.demospring.controller;

import com.example.demospring.DTO.LoginDTO;
import com.example.demospring.models.Login;
import com.example.demospring.models.User;
import com.example.demospring.sevices.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class APILoginController {
    @Autowired
    private ILoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<?> getAllAccount(){
        List<LoginDTO> logins = loginService.findAll();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id) {
        Optional<LoginDTO> login = loginService.findById(id);
        if (login.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PostMapping("/login/check")
    public ResponseEntity<?> checkAccount(@RequestBody Login login){
        String password = Base64.getEncoder().encodeToString(login.getPassword().getBytes());
        Optional<LoginDTO> check = loginService.findByUsernameAndPassword(login.getUsername(), password);
        if (check.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addAccount(@RequestBody Login login){
        Optional<LoginDTO> checkAccount = loginService.findByUsername(login.getUsername());
        if (checkAccount.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        user.setName("User " + userId.substring(0, 5));
        user.setAvatar("avt.png");
        login.setPassword(Base64.getEncoder().encodeToString(login.getPassword().getBytes()));
        login.setUserRole(0L);
        user.setLogin(login);
        login.setUser(user);
        loginService.save(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/login")
    public ResponseEntity<?> updateAccount(@RequestBody Login login){

        login.setPassword(Base64.getEncoder().encodeToString(login.getPassword().getBytes()));
        loginService.save(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id){
        loginService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
