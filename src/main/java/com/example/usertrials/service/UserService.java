package com.example.usertrials.service;

import com.example.usertrials.dto.CreateUserDto;
import com.example.usertrials.dto.UpdateUserDto;
import com.example.usertrials.dto.UserDto;
import com.example.usertrials.dto.UserDtoConverter;
import com.example.usertrials.exceptions.UserNotFoundException;
import com.example.usertrials.model.User;
import com.example.usertrials.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("Kullanıcı bulunamadı"));
        return userDtoConverter.convert(user);
    }

    public User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        return userRepository.save(user);

    }

    public User updateUser(int id, UpdateUserDto updateUserDto) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("id bulunamadı"));
        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());
        userRepository.save(user);
        return user;
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted! : " +id;
    }
}
