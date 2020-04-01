/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.validators;

import com.spring.poll.dtos.RegisterUserDto;
import com.spring.poll.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author George.Giazitzis
 */
@Component
public class RegisterUserDtoValidator implements Validator {

    private static final int MINIMUM_PASSWORD_LENGTH = 6;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Override
    public boolean supports(Class<?> type) {
        return RegisterUserDto.class.equals(type);
    }
  
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "field.required");
        RegisterUserDto dto = (RegisterUserDto) target;
        if (dto.getPassword() != null && dto.getPassword().length() < MINIMUM_PASSWORD_LENGTH) {
            errors.rejectValue("password", "field.min.length", new Object[]{MINIMUM_PASSWORD_LENGTH},
                    "Password must be at least " + MINIMUM_PASSWORD_LENGTH + " characters in length.");
        }
        if (!dto.getPassword().equals(dto.getPassword2())) {
            errors.rejectValue("password2", "password.mismatch");
        }
        if (userServiceInterface.checkUserName(dto.getUsername()).isPresent()) {
            errors.rejectValue("username", "username.unavailable");
        }
    }
}
