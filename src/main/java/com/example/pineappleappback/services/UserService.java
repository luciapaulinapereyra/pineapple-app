package com.example.pineappleappback.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.repositories.UserRepository;
import com.example.pineappleappback.response.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service //le indico que es el servicio
public class UserService {
   @Autowired
   UserRepository userRepository;

   public ResponseEntity<Object> getUsers() {    //para obtener todos los usuarios
        try {
              ArrayList<UserModel> users= new ArrayList <UserModel>();
            userRepository.findAll().forEach(users::add);
             if (users.isEmpty()) {
                  return ResponseHandler.generateResponse("The list is empty", HttpStatus.NOT_FOUND, null,false);
             }
             return ResponseHandler.generateResponse("", HttpStatus.OK, users,false);
        } catch (Exception e) {
          return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null,true);
        }            
        
   }

   public ResponseEntity<Object> createUser(UserModel user) {  //para guardar el usuario
        UserModel newUser = new UserModel();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setRole(user.getRole());
        try { 
        UserModel savedUser = userRepository.save(newUser);
        return ResponseHandler.generateResponse("User created!",HttpStatus.CREATED,savedUser,false);
     } catch(Exception err) {
          return ResponseHandler.generateResponse("Error",HttpStatus.INTERNAL_SERVER_ERROR,null,true);
     }
        
   }

   public ResponseEntity<Object> deleteUser(Long id) {
        try {
             userRepository.deleteById(id);
    
             return ResponseHandler.generateResponse("User deleted",HttpStatus.CREATED,null,false);
        } catch (Exception err) {
          return ResponseHandler.generateResponse("Error,user not found",HttpStatus.NOT_FOUND,null,true);
        }
   }

   public ResponseEntity<Object> modifyUser(Long id,UserModel userRequest) {
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
             return ResponseHandler.generateResponse("User updated!",HttpStatus.OK,modifiedUser,false);
        }
        return ResponseHandler.generateResponse("Error, user not found",HttpStatus.NOT_FOUND,null,true);
   }
}
