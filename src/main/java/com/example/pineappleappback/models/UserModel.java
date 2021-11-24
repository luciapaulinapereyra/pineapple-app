package com.example.pineappleappback.models;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.*;

//This is de user model. Here we see what type of information of user we are going to handle.
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;

    @ManyToOne() // Many users to one role
    @JoinColumn(name = "role_id")
    private RoleModel role;

    // Setters & Getters
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
        this.id = id;
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

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public RoleModel getRole() {
        return role;
    }

    public <List> UserModel getInformation(UserModel user) {
        user.createdDate = this.createdDate;
        user.username = this.username;
        user.id = this.id;
        return user;
    }

}