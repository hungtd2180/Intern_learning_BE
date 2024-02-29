package com.example.demospring.sevices;

import com.example.demospring.DTO.LoginDTO;
import com.example.demospring.models.Login;

import java.util.List;
import java.util.Optional;

public interface ILoginService {
    void save(Login login);
    void delete(Long id);
    Optional<LoginDTO> findById(Long id);
    Optional<Login> findByLoginId(Long id);
    Optional<LoginDTO> findByUsername(String username);
    Optional<LoginDTO> findByUsernameAndPassword(String username, String password);
    List<LoginDTO> findAll();
}
