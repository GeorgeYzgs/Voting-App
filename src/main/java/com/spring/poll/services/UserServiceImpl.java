/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.services;

import com.spring.poll.models.User;
import com.spring.poll.repos.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author George.Giazitzis
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void insertUser(User u) {
        u.setUserpassword(passwordEncoder.encode(u.getUserpassword()));
        userRepository.save(u);
    }

    @Override
    public Optional<User> checkUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllCandidates() {
        return userRepository.getALlCandidates();
    }

    @Override
    public User getUserByID(Integer userID) {
       return userRepository.getOne(userID);
    }  
}
