package com.example.pineappleappback.models;

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

    // @Column(name = "created_at")
    // private Date creationDate;

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private int role;

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
    
    // public Date getCreationDate() {
    //     return creationDate;
    // }

    // public void setCreationDate(Date creationDate) {
    //     this.creationDate=creationDate;
    // }
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}