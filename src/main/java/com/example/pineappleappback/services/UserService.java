package com.example.pineappleappback.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.pineappleappback.dto.UserListDTO;
import com.example.pineappleappback.models.RoleModel;
import com.example.pineappleappback.models.UserModel;
import com.example.pineappleappback.repositories.RoleRepository;
import com.example.pineappleappback.repositories.UserRepository;
import com.example.pineappleappback.response.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//This is the user service. Here all the logic of business is implemented.
@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;
     @Autowired
     private RoleRepository roleRepository;

     static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

     public static String encriptarBCrypt(String password) { // Encrypt the password
          return passwordEncoder.encode(password);
     }

     public ResponseEntity<Object> searchByUserPassword(String user, String password) { // to login

          try {
               Optional<UserModel> u = userRepository.findByUsername(user);

               if (passwordEncoder.matches(password, u.get().getPassword())) {
                    UserListDTO userLogged = new UserListDTO(u.get());
                    return ResponseHandler.generateResponse("", HttpStatus.OK, userLogged, false);
               } else {
                    return ResponseHandler.generateResponse("Failed", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
               }
          } catch (Exception e) {

               return ResponseHandler.generateResponse("Failed", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
          }

     }

     public ResponseEntity<Object> getUsers() { // to get all users
          try {
               ArrayList<UserModel> users = new ArrayList<UserModel>();
               ArrayList<UserListDTO> usersDTO = new ArrayList<>();
               userRepository.findAll().forEach(users::add);

               for (UserModel user : users) {
                    usersDTO.add(new UserListDTO(user));
               }

               if (users.isEmpty()) {
                    return ResponseHandler.generateResponse("The list is empty", HttpStatus.NOT_FOUND, null, false);
               }

               return ResponseHandler.generateResponse("", HttpStatus.OK, usersDTO, false);
          } catch (Exception e) {
               return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
          }

     }

     public ResponseEntity<Object> createUser(UserModel user) { // to create and save a user
          try {
               Optional<UserModel> existingUser = userRepository.findByUsername(user.getUsername());
               if (existingUser.isPresent())
                    return ResponseHandler.generateResponse("The user already exists ", HttpStatus.BAD_REQUEST, null,
                              true);

               Optional<UserModel> existingUserByEmail = userRepository.findByEmail(user.getEmail());
               if (existingUserByEmail.isPresent())
                    return ResponseHandler.generateResponse("The email already exists", HttpStatus.BAD_REQUEST, null,
                              true);
               Optional<RoleModel> existingRole = roleRepository.findById(user.getRole().getId());
               if (!existingRole.isPresent())
                    return ResponseHandler.generateResponse("The role doesn't exists", HttpStatus.BAD_REQUEST, null,
                              true);
               UserModel newUser = new UserModel();
               newUser.setName(user.getName());
               newUser.setEmail(user.getEmail());
               newUser.setLastName(user.getLastName());
               newUser.setPassword(encriptarBCrypt(user.getPassword()));
               newUser.setUsername(user.getUsername());
               newUser.setCreatedDateToNow();
               newUser.setRole(existingRole.get());
               UserModel savedUser = userRepository.save(newUser);
               UserListDTO userResponse = new UserListDTO(savedUser);
               return ResponseHandler.generateResponse("User created!", HttpStatus.CREATED, userResponse, false);
          } catch (Exception err) {
               return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
          }

     }

     public ResponseEntity<Object> deleteUser(Long id) { // to delete a user
          try {
               userRepository.deleteById(id);

               return ResponseHandler.generateResponse("User deleted", HttpStatus.CREATED, null, false);
          } catch (Exception err) {
               return ResponseHandler.generateResponse("Error,user not found", HttpStatus.NOT_FOUND, null, true);
          }
     }

     public ResponseEntity<Object> modifyUser(Long id, UserModel userRequest) { // to edit a user
          Optional<UserModel> user = userRepository.findById(id);

          if (!user.isPresent())
               return ResponseHandler.generateResponse("Error, user not found", HttpStatus.NOT_FOUND, null, true);

          UserModel userm = user.get();
          if (userRequest.getName() != null)
               userm.setName(userRequest.getName());
          if (userRequest.getEmail() != null)
               userm.setEmail(userRequest.getEmail());
          if (userRequest.getLastName() != null)
               userm.setLastName(userRequest.getLastName());
          if (userRequest.getPassword() != null)
               userm.setPassword(encriptarBCrypt(userRequest.getPassword()));
          if (userRequest.getUsername() != null)
               userm.setUsername(userRequest.getUsername());
          if (userRequest.getRole() != null) {
               Optional<RoleModel> existingRole = roleRepository.findById(userRequest.getRole().getId());
               if (!existingRole.isPresent())
                    return ResponseHandler.generateResponse("The role doesn't exists", HttpStatus.BAD_REQUEST, null,
                              true);
               userm.setRole(existingRole.get());
          }

          UserModel modifiedUser = userRepository.save(userm);
          UserListDTO userResponse = new UserListDTO(modifiedUser);
          return ResponseHandler.generateResponse("User updated!", HttpStatus.OK, userResponse, false);
     }
}
