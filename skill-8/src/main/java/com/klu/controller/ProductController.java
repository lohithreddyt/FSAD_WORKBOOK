package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    // 🔹 Category Search
    @GetMapping("/category/{category}")
    public List<Product> getCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // 🔹 Price Range Filter
    @GetMapping("/filter")
    public List<Product> getRange(@RequestParam double min,
                                 @RequestParam double max) {
        return service.getByRange(min, max);
    }

    // 🔹 Sorted by Price
    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSorted();
    }

    // 🔹 Expensive Products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensive(price);
    }
}