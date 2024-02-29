package com.example.demospring.sevices;

import com.example.demospring.DTO.UserDTO;
import com.example.demospring.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void save(User user);
    void delete(String id);
    Optional<UserDTO> findById(String id);
    Optional<User> findByUserId(String id);
    List<UserDTO> findAll();
}
