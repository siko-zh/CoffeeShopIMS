package com.zholdigaliev.coffeeshopims.dto.SupplierDto;
import lombok.Data;

@Data
public class SupplierRequest {

    private String name;

    private String contactName;

    private String phone;

    private String email;
}
