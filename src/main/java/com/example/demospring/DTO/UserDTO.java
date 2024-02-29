package com.example.demospring.DTO;

import com.example.demospring.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String avatar;
    private String status;
    private String description;
    public static UserDTO fromEntity(User user){
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAvatar(), user.getStatus(), user.getDescription());
    }
}
