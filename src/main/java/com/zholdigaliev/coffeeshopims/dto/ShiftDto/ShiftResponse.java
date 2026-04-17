package com.zholdigaliev.coffeeshopims.dto.ShiftDto;

import java.time.LocalDateTime;

import com.zholdigaliev.coffeeshopims.entity.ShiftStatus;
import lombok.Data;

@Data
public class ShiftResponse {
    private Long id;

    private String branchName;

    private String openedByUsername;

    private String closedByUsername;

    private ShiftStatus status;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    private String notes;
}
