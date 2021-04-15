package com.OrderSystem.merchandise.controller;

import com.OrderSystem.merchandise.data.ProductRepository;
import com.OrderSystem.merchandise.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private ProductRepository repository;

    public ProductRestController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer/{customerId}")
    public List<Product> getAllCustomerId(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }


    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{product_id}")
    public Product getOne(@PathVariable int product_id) {
        try{
            return  repository.findById(product_id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }
    @PostMapping
    public Product create(@RequestBody Product product){
        repository.save(product);
        return product ;
    }
    @PutMapping("/{product_id}")
    public Product update(@PathVariable int product_id,
                          @RequestBody Product product) {
        Product record = repository.findById(product_id).get();
        record.setPrice(product.getPrice());
        repository.save(record);
        return record;
    }
    @DeleteMapping("/{product_id}")
    public Product delete(@PathVariable int product_id) {
        Product record = repository.findById(product_id).get();
        repository.deleteById(product_id);
        return record;
    }



}
