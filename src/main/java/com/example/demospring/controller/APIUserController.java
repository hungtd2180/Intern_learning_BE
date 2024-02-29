package com.example.demospring.controller;

import com.example.demospring.DTO.UserDTO;
import com.example.demospring.models.User;
import com.example.demospring.sevices.ILoginService;
import com.example.demospring.sevices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class APIUserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ILoginService loginService;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<UserDTO> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        Optional<UserDTO> user = userService.findById(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User findUser = userService.findByUserId(user.getId()).get();
        findUser.setId(user.getId());
        findUser.setName(user.getName());
        findUser.setEmail(user.getEmail());
        findUser.setAvatar(user.getAvatar());
        findUser.setDescription(user.getDescription());
        findUser.setStatus("Active");
        userService.save(findUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        User findeUser = userService.findByUserId(id).get();
        loginService.delete(findeUser.getLogin().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
