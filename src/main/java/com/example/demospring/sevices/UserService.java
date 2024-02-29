package com.example.demospring.sevices;

import com.example.demospring.DTO.UserDTO;
import com.example.demospring.models.User;
import com.example.demospring.repositoies.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> findById(String id) {
        return userRepository.findById(id)
                .stream()
                .findFirst().map(UserDTO::fromEntity);
    }

    @Override
    public Optional<User> findByUserId(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }
}
