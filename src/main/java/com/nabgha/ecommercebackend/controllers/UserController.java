package com.nabgha.ecommercebackend.controllers;


import com.nabgha.ecommercebackend.dtos.ChangePasswordRequest;
import com.nabgha.ecommercebackend.dtos.RegisterUserRequest;
import com.nabgha.ecommercebackend.dtos.UpdateUserRequest;
import com.nabgha.ecommercebackend.dtos.UserDto;
import com.nabgha.ecommercebackend.mappers.UserMapper;
import com.nabgha.ecommercebackend.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    // method: GET, POST, PUT, DELETE
    public List<UserDto> getAllUsers(
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
        if (!Set.of("name", "email").contains(sort)) {
           return userRepository.findAll().stream().map(userMapper::toDto).toList();
        }
        return userRepository.findAll(Sort.by(sort).descending())
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build(); // if not found return 404
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @Valid @RequestBody RegisterUserRequest request,//1. Receives JSON and maps it to the DTO
            UriComponentsBuilder uriBuilder
    ) {
        // 1. Check if email exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email is already taken");
        }
        // 2. The Mapper converts the DTO into a User Entity
        var user = userMapper.toEntity(request);
        // 3. Save the entity to the database via the Repository
        userRepository.save(user);

        // 4. Convert the saved Entity (which now has an ID) into a UserDto for the response
        var userDto = userMapper.toDto(user);
        // 5. Build a URL for the new resource (e.g., /users/5)
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        // 6. Return HTTP 201 (Created) with the Location header and the User data
        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request
    ) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userMapper.update(request, user);
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long id,
            @RequestBody ChangePasswordRequest request
            ) {
        // add it later
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if (!user.getPassword().equals(request.getOldPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        user.setPassword(request.getNewPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }


}
