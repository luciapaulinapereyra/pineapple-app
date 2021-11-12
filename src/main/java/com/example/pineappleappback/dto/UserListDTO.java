
package com.example.pineappleappback.dto;

import java.util.Date;

import com.example.pineappleappback.models.UserModel;

public class UserListDTO {
    private String username;
    private Long id;
    private Date createdDate;
    
    public UserListDTO(UserModel user) {
        this.username = user.getUsername();
        this.id = user.getId();
        this.createdDate = user.getCreatedDate();

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

}
