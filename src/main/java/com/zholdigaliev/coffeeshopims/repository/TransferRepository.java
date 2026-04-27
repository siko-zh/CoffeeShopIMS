package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.entity.Branch;
import com.zholdigaliev.coffeeshopims.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    Optional<Transfer> findAllByFromBranchOrToBranch(Branch branchFrom, Branch branchTo);
}
