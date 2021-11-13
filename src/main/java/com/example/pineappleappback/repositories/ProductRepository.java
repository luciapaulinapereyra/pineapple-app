package com.example.pineappleappback.repositories;

import java.util.ArrayList;

import com.example.pineappleappback.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    ArrayList<ProductModel> findByName(String name);
}
