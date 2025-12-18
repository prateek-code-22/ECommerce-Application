package com.app.ecommerceapplication.controller;
import com.app.ecommerceapplication.dto.UserRequest;
import com.app.ecommerceapplication.dto.UserResponse;
import com.app.ecommerceapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //for creating constructor for line16
@RestController //for response+controller
@RequestMapping("/api/users") //to define the common mapping
public class UserController {

    //Dependency Injection used
    private final UserService userService;

    //get list of all users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return new ResponseEntity<>(userService.fetchAllUser(), HttpStatus.OK);
    }

    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //create user
    @PostMapping
    public ResponseEntity<String> CreateUser(@RequestBody UserRequest user){
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully!");
    }

    //update user info
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateUser(@PathVariable Long id, @RequestBody UserRequest updatedUserRequest){
        boolean updated = userService.updateUser(id, updatedUserRequest);
        if(updated) return ResponseEntity.ok("User information is updated");
        else
            return ResponseEntity.notFound().build();
    }
}
