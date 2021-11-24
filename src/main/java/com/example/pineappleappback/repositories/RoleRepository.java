package com.example.pineappleappback.repositories;

import com.example.pineappleappback.models.RoleModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This is the Role repository. This class extends the JPA repository to be able to use its functionalities
@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

}
