package com.example.pineappleappback.controllers;

import com.example.pineappleappback.models.ProductModel;
import com.example.pineappleappback.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//This is the controller of the products when where http requests of products are received

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> getProducts() { // To get all the products
        return this.productService.getProducts();
    }

    @GetMapping(path = "/{name}") // To get a product with a specific name
    public ResponseEntity<Object> findByName(@PathVariable("name") String name) {
        return this.productService.findByName(name);
    }

    @GetMapping(path = "/ordered") // To get the products in order
    public ResponseEntity<Object> getOrderedList() {
        return this.productService.getOrderedList();
    }

    @GetMapping(path = "/export") // To send the products to the front so that they are exported in excel
    public ResponseEntity<Object> getList() {
        return this.productService.getProducts();
    }

    @PostMapping()
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel product) { // To create a product
        return this.productService.createProduct(product);
    }

    @PutMapping(path = "/{id}") // To edit a product
    public ResponseEntity<Object> editProduct(@PathVariable("id") Long id, @RequestBody ProductModel product) {
        return this.productService.editProduct(id, product);
    }

    @DeleteMapping(path = "/{id}") // To delete a product
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        return this.productService.deleteProduct(id);
    }

}
