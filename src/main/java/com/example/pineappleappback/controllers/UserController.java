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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Object> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody UserModel user) {
        return this.userService.createUser(user);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> modifyUser(@PathVariable("id") Long id, @RequestBody UserModel userRequest) {
        return this.userService.modifyUser(id, userRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        return this.userService.deleteUser(id);

    }
}
