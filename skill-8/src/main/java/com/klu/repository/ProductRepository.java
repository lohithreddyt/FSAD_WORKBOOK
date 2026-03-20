package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // 🔹 Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    List<Product> findAllByOrderByPriceAsc();

    // 🔹 JPQL Queries

    // Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    // Products above price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensive(@Param("price") double price);

    // Products by category (JPQL)
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findCategoryJPQL(@Param("category") String category);
}