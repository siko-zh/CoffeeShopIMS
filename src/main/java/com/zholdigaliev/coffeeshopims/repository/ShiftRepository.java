package com.zholdigaliev.coffeeshopims.repository;

import com.zholdigaliev.coffeeshopims.entity.Branch;
import com.zholdigaliev.coffeeshopims.entity.Shift;
import com.zholdigaliev.coffeeshopims.entity.ShiftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Optional<Shift> findAllByBranch(Branch branch);
    Optional<Shift> findByBranch(Branch branch);

    Optional<Shift> findByBranchAndStatus(Branch branch, ShiftStatus status);
}
