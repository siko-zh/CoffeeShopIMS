package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.StockDto.StockResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.StockMapper;
import com.zholdigaliev.coffeeshopims.entity.*;
import com.zholdigaliev.coffeeshopims.repository.BranchRepository;
import com.zholdigaliev.coffeeshopims.repository.ProductRepository;
import com.zholdigaliev.coffeeshopims.repository.StockMovementRepository;
import com.zholdigaliev.coffeeshopims.repository.StockRepository;
import com.zholdigaliev.coffeeshopims.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;
    private final StockMapper mapper;

    @Override
    public List<StockResponse> getByBranch(Long branchId) {
        return stockRepository.findAll().stream()
                .filter(s-> s.getBranch().getId().equals(branchId))
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<StockResponse> getLowStock(Long branchId) {
        return stockRepository.findAll().stream()
                .filter(s-> s.getBranch().getId().equals(branchId))
                .filter(s -> s.getQuantity().compareTo(s.getMinQuantity()) <= 0)
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public StockResponse setMinQuantity(Long id, BigDecimal minQuantity) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found: " + id));

        stock.setMinQuantity(minQuantity);

        Stock savedStock = stockRepository.save(stock);

        return mapper.toResponse(savedStock);
    }

    @Override
    @Transactional
    public StockResponse writeOff(Long branchId, Long productId, BigDecimal quantity, String reason) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + branchId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        Stock stock = stockRepository.findStockByBranchAndProduct(branch, product);

        if (stock.getQuantity().compareTo(quantity) < 0) {
            throw new RuntimeException("Out of stock");
        }

        stock.setQuantity(stock.getQuantity().subtract(quantity));

        Stock stockSaved = stockRepository.save(stock);
        StockMovement stockMovement = new StockMovement();

        stockMovement.setProduct(product);
        stockMovement.setBranch(branch);
        stockMovement.setType(MovementType.OUT);
        stockMovement.setQuantity(quantity);
        stockMovement.setReason(reason);

        stockMovementRepository.save(stockMovement);

        return mapper.toResponse(stockSaved);
    }
}
