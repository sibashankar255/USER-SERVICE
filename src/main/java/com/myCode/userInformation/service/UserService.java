package com.myCode.userInformation.service;

import com.myCode.userInformation.dto.UserDTO;
import com.myCode.userInformation.entity.User;
import com.myCode.userInformation.mapper.UserMapper;
import com.myCode.userInformation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public User addUser(User user) {
        return userRepo.save(user);

    }

    public ResponseEntity<User> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchedUser =  userRepo.findById(userId);
        if(fetchedUser.isPresent())
            return new ResponseEntity<>(fetchedUser.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
