package com.example.pineappleappback.controllers;

import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

//This is the controller of users when where http requests of users are received
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Object> getUsers() { // To get the users
        return this.userService.getUsers();
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody UserModel user) { // To create a user
        return this.userService.createUser(user);
    }

    @PostMapping(path = "/login") // To get username and password to the login
    public ResponseEntity<Object> login(@RequestBody UserModel userRequest) {
        return this.userService.searchByUserPassword(userRequest.getUsername(), userRequest.getPassword());
    }

    @PutMapping(path = "/{id}") // To edit a user
    public ResponseEntity<Object> modifyUser(@PathVariable("id") Long id, @RequestBody UserModel userRequest) {
        return this.userService.modifyUser(id, userRequest);
    }

    @DeleteMapping(path = "/{id}") // To delete a user
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        return this.userService.deleteUser(id);

    }
    
    @GetMapping(path = "/email/{email}") //To find by a user by its email
    public ResponseEntity<Object> getByEmail(@PathVariable("email") String email){
        return this.userService.getByEmail(email);
    }
}
