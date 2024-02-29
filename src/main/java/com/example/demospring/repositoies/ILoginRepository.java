package com.example.demospring.repositoies;

import com.example.demospring.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> getLoginByUsername(String username);
    Optional<Login> getLoginByUsernameAndPassword(String username, String password);
}
