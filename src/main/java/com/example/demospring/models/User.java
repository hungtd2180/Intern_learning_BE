package com.example.demospring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String avatar;
    private String status;
    private String description;
    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @JsonIgnore
    private Login login;
}
