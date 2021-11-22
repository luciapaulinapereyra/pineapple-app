
package com.example.pineappleappback.dto;

import java.util.Date;

import com.example.pineappleappback.models.RoleModel;
import com.example.pineappleappback.models.UserModel;

public class UserListDTO {
    private String username;
    private Long id;
    private Date createdDate;
    private String name;
    private String lastName;
    private String email;
    private RoleModel role;
    
    public UserListDTO(UserModel user) {
        this.username = user.getUsername();
        this.id = user.getId();
        this.createdDate = user.getCreatedDate();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();

    }

    public UserListDTO() {}

    public String getUsername() {
        return username;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   

    public RoleModel getRole() {
        return role;
    }
    public void setRole(RoleModel role) {
        this.role = role;
    }   
}
