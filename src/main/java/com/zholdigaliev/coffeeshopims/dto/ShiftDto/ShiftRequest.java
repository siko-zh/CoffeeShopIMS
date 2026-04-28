package com.zholdigaliev.coffeeshopims.dto.ShiftDto;
import lombok.Data;

@Data
public class ShiftRequest {
    private Long branchId;

    private String notes;
}
