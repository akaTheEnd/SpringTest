package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Exist");
        }
        return User.toModel(userRepo.save(user));
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Not found");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
