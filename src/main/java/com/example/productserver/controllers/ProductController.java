package com.example.productserver.controllers;

import com.example.productserver.models.Product;
import com.example.productserver.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    //GET API to get all the saved Product Details from the database
    @GetMapping
    public List<Product> list() {
        return productRepository.findAll();
    }

    //GET API to get a particular product details from the database
    @GetMapping
    @RequestMapping("{id}")
    public Product get(@PathVariable Long id) throws Exception {
        Product product = productRepository.findByProductId(id);
        if (product == null)
            throw new Exception("No product for product id=" + id);
        return product;
    }

    //POST API to save a Product Data into the database
    @PostMapping
    public Product create(@RequestBody final Product famous5) {
        System.out.println("Product added");
        return productRepository.saveAndFlush(famous5);
    }

    //DELETE API to delete a Product Data from the database
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product Deleted");
    }

    //PUT API to edit a Product Data in the database
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Product newProduct) throws Exception {
        //get existing data
        Product existingProduct = productRepository.findByProductId(id);
        if (existingProduct == null)
            throw new Exception("No product for product id=" + id);

        //update data
        BeanUtils.copyProperties(newProduct, existingProduct, "id");

        productRepository.saveAndFlush(existingProduct);
        return ResponseEntity.ok("Product updated");
    }
}
