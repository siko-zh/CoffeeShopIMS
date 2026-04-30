package com.zholdigaliev.coffeeshopims.service.impl;

import com.zholdigaliev.coffeeshopims.dto.UserDto.UserRequest;
import com.zholdigaliev.coffeeshopims.dto.UserDto.UserResponse;
import com.zholdigaliev.coffeeshopims.dto.mapper.UserMapper;
import com.zholdigaliev.coffeeshopims.entity.Branch;
import com.zholdigaliev.coffeeshopims.entity.User;
import com.zholdigaliev.coffeeshopims.repository.BranchRepository;
import com.zholdigaliev.coffeeshopims.repository.UserRepository;
import com.zholdigaliev.coffeeshopims.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(UserRequest request) {


        String password = request.getPassword();

        String hashedPassword = passwordEncoder.encode(password);

        User user = mapper.toEntity(request);

        user.setPasswordHash(hashedPassword);
        user.setBranch(branchRepository.findById(request.getBranchId()).
                orElseThrow(() -> new RuntimeException("Branch not found: " + request.getBranchId())));

        User saved = userRepository.save(user);

        return mapper.toResponse(saved);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        return mapper.toResponse(user);
    }

    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        String currentPassword = user.getPasswordHash();

        if(!passwordEncoder.matches(oldPassword, currentPassword)) {
            throw new RuntimeException("Incorrect old password");
        }

        user.setPasswordHash(passwordEncoder.encode(newPassword));

        userRepository.save(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        Branch branch = branchRepository.findById(request.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found: " + request.getBranchId()));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setBranch(branch);

        User savedUser = userRepository.save(user);

        return mapper.toResponse(savedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        userRepository.delete(user);
    }
}
