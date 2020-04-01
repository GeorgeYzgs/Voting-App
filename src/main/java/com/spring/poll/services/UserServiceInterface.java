/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.services;

import com.spring.poll.models.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author George.Giazitzis
 */
public interface UserServiceInterface {

    public void insertUser(User u);

    public Optional<User> checkUserName(String username);

    public List<User> getAllCandidates();

    public User getUserByID(Integer userID);

}
