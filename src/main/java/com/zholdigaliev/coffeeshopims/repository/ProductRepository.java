package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
