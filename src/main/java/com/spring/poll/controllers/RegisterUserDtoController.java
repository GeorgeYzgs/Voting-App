/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.controllers;

import com.spring.poll.dtos.RegisterUserDto;
import com.spring.poll.models.User;
import com.spring.poll.services.RoleServiceInterface;
import com.spring.poll.services.UserServiceInterface;
import com.spring.poll.validators.RegisterUserDtoValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author George.Giazitzis
 */
@Controller
public class RegisterUserDtoController {

    @Autowired
    RoleServiceInterface roleServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    RegisterUserDtoValidator registerUserDtoValidator;

    @InitBinder("RegisterUserDto")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(registerUserDtoValidator);
    }

    //passes a new DTO to the jsp to be filled as a new registered user.
    @GetMapping("/preRegister")
    public String preRegister(ModelMap mm) {
        mm.addAttribute("registeruser", new RegisterUserDto());
        mm.addAttribute("allroles", roleServiceInterface.getAllRoles());
        return "register";
    }

    //unwraps the dto obbject and creates a new user, after validating all its fields.
    @PostMapping("/doregister")
    public String doRegister(@Valid @ModelAttribute("registeruser") RegisterUserDto dto,
            BindingResult bindingResult, ModelMap mm) {
        if (bindingResult.hasErrors()) {
            mm.addAttribute("registeruser", dto);
            mm.addAttribute("allroles", roleServiceInterface.getAllRoles());
            return "register";
        }
        userServiceInterface.insertUser(new User(dto));
        mm.addAttribute("myuser", new User());
        mm.addAttribute("message","User has been created!");
        return "index";
    }
}
