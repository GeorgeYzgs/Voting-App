/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.controllers;

import com.spring.poll.models.User;
import com.spring.poll.models.Vote;
import com.spring.poll.services.UserServiceInterface;
import com.spring.poll.services.VoteServiceInterface;
import com.spring.poll.validators.UserValidator;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author George.Giazitzis
 */
@Controller
public class UserController {

    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    VoteServiceInterface voteServiceInterface;
    @Autowired
    UserValidator userValidator;

    @InitBinder("User")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    //passes an empty user obbject to the jsp to be filled for login.
    @GetMapping("/")
    public String showemptyform(ModelMap mm) {
        mm.addAttribute("myuser", new User());
        return "index";
    }

    //validates the user object parameters and then logs him in as a session attribute.
    @PostMapping("/dologin")
    public String login(@Valid @ModelAttribute("myuser") User user,
            BindingResult bindingResult, ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            mm.addAttribute("myuser", user);
            return "index";
        }
        User loggedUser = userServiceInterface.checkUserName(user.getUsername()).get();
        List<User> allcandidates = userServiceInterface.getAllCandidates();
        if (loggedUser.getRoleid().getRoleid() == 2) {
            // Candidate must not be able to vote for himeself.
            allcandidates.remove(user);
        }
        mm.addAttribute("allcandidates", allcandidates);
        session.setAttribute("polluser", loggedUser);
        return "votepage";
    }

    //submits a vote with the chosen candidate, as a logged in user, then logs out.
    @PostMapping("/voteSubmit")
    public String vote(@RequestParam("CandidateID") Integer candidateId, HttpSession session) {
        User candidateVoted = userServiceInterface.getUserByID(candidateId);
        User voter = (User) session.getAttribute("polluser");
        voteServiceInterface.insertVote(new Vote(voter, candidateVoted));
        session.removeAttribute("polluser");
        return "votesuccess";
    }
}
