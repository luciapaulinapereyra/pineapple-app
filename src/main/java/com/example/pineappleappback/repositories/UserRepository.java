package com.example.pineappleappback.repositories;

import java.util.ArrayList;

import com.example.pineappleappback.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByName(String name); //Solo con el método Abstract y el nombre springboot se encarga
     //otros metodos posibles: find by nombre, by email.
}
