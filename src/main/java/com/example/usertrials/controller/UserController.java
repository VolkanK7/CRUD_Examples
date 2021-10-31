package com.example.usertrials.controller;

import com.example.usertrials.dto.CreateUserDto;
import com.example.usertrials.dto.UpdateUserDto;
import com.example.usertrials.dto.UserDto;
import com.example.usertrials.model.User;
import com.example.usertrials.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody UpdateUserDto updateUserDto){
        return ResponseEntity.ok(userService.updateUser(id,updateUserDto));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
