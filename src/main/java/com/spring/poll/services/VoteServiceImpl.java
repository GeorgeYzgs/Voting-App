/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.services;

import com.spring.poll.models.User;
import com.spring.poll.models.Vote;
import com.spring.poll.repos.VoteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author George.Giazitzis
 */
@Service
public class VoteServiceImpl implements VoteServiceInterface {

    @Autowired
    VoteRepository voteRepository;

    @Override
    public boolean hasVoted(User voterid) {
        Optional<Vote> test = voteRepository.findByVoterid(voterid);
        return test.isPresent();
    }

    @Override
    public void insertVote(Vote vote) {
        voteRepository.save(vote);
    }
}
