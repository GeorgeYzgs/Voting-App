/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.validators;

import com.spring.poll.models.User;
import com.spring.poll.services.UserServiceInterface;
import com.spring.poll.services.VoteServiceInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author George.Giazitzis
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    VoteServiceInterface voteServiceInterface;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;
        Optional<User> tempuser = userServiceInterface.checkUserName(u.getUsername());
        if (!tempuser.isPresent()) {
            errors.rejectValue("username", "invalid.credentials");
            return;
        }
        User user = tempuser.get();
        if (!passwordEncoder.matches(u.getUserpassword(), user.getUserpassword())) {
            errors.rejectValue("username", "invalid.credentials");
            return;
        }
        boolean hasVoted = voteServiceInterface.hasVoted(user);
        if (hasVoted) {
            errors.rejectValue("username", "voted");
        }
    }
}
