package com.zholdigaliev.coffeeshopims.dto.UserDto;

import com.zholdigaliev.coffeeshopims.entity.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;

    private String username;

    private String email;

    private Role role;

    private Long branchId;

    private String branchName;
}
