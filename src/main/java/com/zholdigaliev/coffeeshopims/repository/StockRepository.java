package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.entity.Branch;
import com.zholdigaliev.coffeeshopims.entity.Product;
import com.zholdigaliev.coffeeshopims.entity.Stock;
import com.zholdigaliev.coffeeshopims.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findStockByBranchAndProduct(Branch branch, Product product);
}
