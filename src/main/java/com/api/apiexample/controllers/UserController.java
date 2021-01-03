package com.api.apiexample.controllers;

import com.api.apiexample.domain.User;
import com.api.apiexample.dto.UserCreationRequest;
import com.api.apiexample.interfaces.IUserService;
import com.api.apiexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> listAll() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationRequest userToCreate) throws Exception {
        return userService.create(userToCreate);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) {
        userService.delete(userId);
        return ResponseEntity.status(200).body("{}");
    }

}
