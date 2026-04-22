package com.zholdigaliev.coffeeshopims.service;

import com.zholdigaliev.coffeeshopims.dto.UserDto.UserRequest;
import com.zholdigaliev.coffeeshopims.dto.UserDto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest request);
    List<UserResponse> getAll();
    UserResponse getById(Long id);
    UserResponse update(Long id, UserRequest request);
    void updatePassword(Long id, String oldPassword, String newPassword);
    void delete(Long id);
}
