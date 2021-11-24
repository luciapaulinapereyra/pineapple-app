package com.example.pineappleappback.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import com.example.pineappleappback.models.ProductModel;
import com.example.pineappleappback.repositories.ProductRepository;
import com.example.pineappleappback.response.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//This is the product service. Here all the logic of business is implemented.
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Object> getProducts() { // Get all products
        try {
            ArrayList<ProductModel> products = new ArrayList<ProductModel>();
            productRepository.findAll().forEach(products::add);

            if (products.isEmpty()) {
                return ResponseHandler.generateResponse("The list is empty", HttpStatus.NOT_FOUND, null, false);
            }

            return ResponseHandler.generateResponse("", HttpStatus.OK, products, false);
        } catch (Exception err) {

            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
        }
    }

    public ResponseEntity<Object> findByName(String name) { // To find by name
        try {
            ArrayList<ProductModel> products = new ArrayList<ProductModel>();
            productRepository.findByName(name).forEach(products::add);
            if (products.isEmpty()) {
                return ResponseHandler.generateResponse("There are no products with that name ", HttpStatus.NOT_FOUND,
                        null, false);
            }
            return ResponseHandler.generateResponse("", HttpStatus.OK, products, false);
        } catch (Exception err) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
        }
    }

    public ResponseEntity<Object> createProduct(ProductModel product) { // Create and save a product

        ProductModel newProduct = new ProductModel();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setUnit_price(product.getUnit_price());
        newProduct.setUrl_image(product.getUrl_image());
        newProduct.setCategory(product.getCategory());

        try {
            ProductModel savedProduct = productRepository.save(newProduct);
            return ResponseHandler.generateResponse("Product created!", HttpStatus.CREATED, savedProduct, false);
        } catch (Exception err) {
            return ResponseHandler.generateResponse(err.toString(), HttpStatus.INTERNAL_SERVER_ERROR, null, true);
        }

    }

    public ResponseEntity<Object> editProduct(Long id, ProductModel productRequest) { // Edit a product
        Optional<ProductModel> product = productRepository.findById(id);

        if (!product.isPresent())
            return ResponseHandler.generateResponse("Error, product not found", HttpStatus.NOT_FOUND, null, true);
        ProductModel newProduct = product.get();
        if (productRequest.getName() != null)
            newProduct.setName(productRequest.getName());
        if (productRequest.getDescription() != null)
            newProduct.setDescription(productRequest.getDescription());
        if (productRequest.getQuantity() != null)
            newProduct.setQuantity(productRequest.getQuantity());
        if (productRequest.getUnit_price() != null)
            newProduct.setUnit_price(productRequest.getUnit_price());
        if (productRequest.getUrl_image() != null)
            newProduct.setUrl_image(productRequest.getUrl_image());
        if (productRequest.getCategory() != null)
            newProduct.setCategory(productRequest.getCategory());

        ProductModel editProduct = productRepository.save(newProduct);
        return ResponseHandler.generateResponse("User updated!", HttpStatus.OK, editProduct, false);
    }

    public ResponseEntity<Object> deleteProduct(Long id) { // Delete a product
        try {
            productRepository.deleteById(id);

            return ResponseHandler.generateResponse("Product deleted", HttpStatus.CREATED, null, false);
        } catch (Exception err) {
            return ResponseHandler.generateResponse("Error,product not found", HttpStatus.NOT_FOUND, null, true);
        }

    }

    public ResponseEntity<Object> getOrderedList() { // Get list in order
        try {
            ArrayList<ProductModel> products = new ArrayList<ProductModel>();
            productRepository.findAll().forEach(products::add);
            Collections.sort(products, (ProductModel p1, ProductModel p2) -> {
                return p1.getName().compareToIgnoreCase(p2.getName());
            });
            return ResponseHandler.generateResponse("", HttpStatus.OK, products, false);
        } catch (Exception err) {

            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, null, true);
        }
    }

}