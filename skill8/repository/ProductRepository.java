
package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Query - Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();

    // JPQL - Products above price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(@Param("price") double price);

    // JPQL - Products by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductsByCategory(@Param("category") String category);
}

