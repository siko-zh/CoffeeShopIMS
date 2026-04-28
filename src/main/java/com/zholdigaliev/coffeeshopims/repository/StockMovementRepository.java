package com.zholdigaliev.coffeeshopims.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.zholdigaliev.coffeeshopims.entity.Shift;
import com.zholdigaliev.coffeeshopims.entity.StockMovement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findAllByBranchIdAndCreatedAtBetween(Long branchId, LocalDateTime start, LocalDateTime end);

    Page<StockMovement> findAllByBranchId(Long branchId, Pageable pageable);

    List<StockMovement> findAllByShift(Shift shift);
}
