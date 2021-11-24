package com.example.pineappleappback.repositories;

import java.util.ArrayList;

import com.example.pineappleappback.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This is the product repository. This class extends the JPA repository to be able to use its functionalities.
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    ArrayList<ProductModel> findByName(String name);
}
