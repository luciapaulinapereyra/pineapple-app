package com.example.pineappleappback.controllers;

import java.util.ArrayList;
import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
         return userService.getUsers();
    }
    @GetMapping(path="/query")
    public ArrayList<UserModel> findByName(@RequestParam("name") String name) {
      return this.userService.findByName(name);
    }
    @PostMapping() 
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String  deleteById(@PathVariable("id") Long id) {
        boolean ok= this.userService.deleteUser(id);
        if(ok) {
            return "The user with id: " + id + " was deleted";
        } else {
            return "Cannot delete the user with the id: " + id;
        }
    }

}
