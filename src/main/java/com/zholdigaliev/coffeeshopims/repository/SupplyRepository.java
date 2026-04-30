package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.dto.SupplyDto.SupplyResponse;
import com.zholdigaliev.coffeeshopims.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    List<Supply> findAllByBranchId(Long branchId);
}
