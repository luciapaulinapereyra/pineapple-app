package com.example.pineappleappback.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //le indico que es el servicio
public class UserService {
   @Autowired
   UserRepository userRepository;


   public ResponseEntity<ArrayList<UserModel>> getUsers() {    //para obtener todos los usuarios
        try {
              ArrayList<UserModel> users= new ArrayList <UserModel>();
            userRepository.findAll().forEach(users::add);
             if (users.isEmpty()) {
                  return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
             }
              return new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }            
        
   }

   public ResponseEntity<UserModel> createUser(UserModel user) {  //para guardar el usuario
        UserModel newUser = new UserModel();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setRole(user.getRole());
        UserModel savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
   }

   public ResponseEntity<HttpStatus> deleteUser(Long id) {
        try {
             userRepository.deleteById(id);
    
              return new ResponseEntity<> (null, HttpStatus.OK);
        } catch (Exception err) {
             return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
        }
   }

   public ResponseEntity<UserModel> modifyUser(Long id,UserModel userRequest) {
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isPresent()) {
             UserModel userm = user.get();
             userm.setName(userRequest.getName());
             userm.setEmail(userRequest.getEmail());
             userm.setLastName(userRequest.getLastName());
             userm.setPassword(userRequest.getPassword());
             userm.setUsername(userRequest.getUsername());
             userm.setRole(userRequest.getRole());

             UserModel modifiedUser = userRepository.save(userm);
             return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }
}
