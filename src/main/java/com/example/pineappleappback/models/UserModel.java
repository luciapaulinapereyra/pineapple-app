package com.example.pineappleappback.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

//import java.util.Date;

import javax.persistence.*;




@Entity
@Table(name = "users")  
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
     
    // @Column(name = "updated_at")
    // private Date modifiedDate;

     @Column(name = "created_at")
     @Temporal(TemporalType.TIMESTAMP)
     Date createdDate;

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private Integer role;

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDateToNow() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

   public Long getId() {
       return id;
   }
   public void setId(long id) {
       this.id= id;
   }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    
//   @PrePersist
//     protected void prePersist() {
//         if (this.creationDate == null) creationDate = new Date();
//         if (this.modifiedDate == null) modifiedDate = new Date();
//     }
    
//     @PreUpdate
//     protected void preUpdate() {
//         this.modifiedDate = new Date();
//     }
    
    // public Date getModifiedDate() {
    //     return modifiedDate;
    // }
    
    //  public Date getCreationDate() {
    //      return creationDate;
    //  }

    //  public void setCreationDate(Date creationDate) {
    //      this.creationDate=creationDate;
     //}
    // public void setModifiedDate(Date modifiedDate) {
    //     this.modifiedDate=modifiedDate;
    // }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
   
    public <List>UserModel getInformation(UserModel user) {
        user.createdDate= this.createdDate;
        user.username=this.username;
        user.id=this.id;
        return user;
    }
       
}