package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
