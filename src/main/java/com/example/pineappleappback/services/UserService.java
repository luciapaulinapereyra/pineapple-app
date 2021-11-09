package com.example.pineappleappback.services;

import java.util.ArrayList;

import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //le indico que es el servicio
public class UserService {
   @Autowired
   UserRepository userRepository;


   public ArrayList<UserModel> getUsers() {                //para obtener todos los usuarios
        return (ArrayList<UserModel>) userRepository.findAll();
   }

   public UserModel saveUser(UserModel user) {  //para guardar el usuario
        return userRepository.save(user);
   }
   public ArrayList<UserModel> findByName(String name) {  //para guardar el usuario
      return userRepository.findByName(name);
}
   public boolean deleteUser(Long id) {
        try {
             userRepository.deleteById(id);
              return true;
        } catch (Exception err) {
             return false;
        }
   }
}
