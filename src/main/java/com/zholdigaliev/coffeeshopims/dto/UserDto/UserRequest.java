package com.zholdigaliev.coffeeshopims.dto.UserDto;

import com.zholdigaliev.coffeeshopims.entity.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String username;

    private String email;

    private  String password;

    private Role role;

    private Long branchId;
}
