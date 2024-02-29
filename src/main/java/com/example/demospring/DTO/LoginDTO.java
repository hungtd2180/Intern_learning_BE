package com.example.demospring.DTO;

import com.example.demospring.models.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private Long id;
    private String username;
    private String password;
    private Long userRole;
    private String userId;
    public static LoginDTO fromEntity(Login login){
        return new LoginDTO(login.getId(), login.getUsername(), login.getPassword(), login.getUserRole(), login.getUser().getId());
    }

}
