package com.app.ecommerceapplication.repository;

import com.app.ecommerceapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
