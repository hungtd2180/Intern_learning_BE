package com.example.demospring.sevices;

import com.example.demospring.DTO.LoginDTO;
import com.example.demospring.models.Login;
import com.example.demospring.repositoies.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService implements ILoginService{
    @Autowired
    private ILoginRepository loginRepository;
    @Override
    public void save(Login login) {
        loginRepository.save(login);
    }

    @Override
    public void delete(Long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Optional<LoginDTO> findById(Long id) {
        return loginRepository.findById(id)
                .stream()
                .findFirst()
                .map(LoginDTO::fromEntity);
    }

    @Override
    public Optional<Login> findByLoginId(Long id) {
        return loginRepository.findById(id);
    }

    @Override
    public Optional<LoginDTO> findByUsername(String username) {
        return loginRepository.getLoginByUsername(username)
                .stream().findFirst().map(LoginDTO::fromEntity);
    }

    @Override
    public Optional<LoginDTO> findByUsernameAndPassword(String username, String password) {
        return loginRepository.getLoginByUsernameAndPassword(username, password)
                .stream()
                .findFirst()
                .map(LoginDTO::fromEntity);
    }

    @Override
    public List<LoginDTO> findAll() {
        return loginRepository.findAll()
                .stream().map(LoginDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
