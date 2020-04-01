/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.services;

import com.spring.poll.models.User;
import com.spring.poll.models.Vote;

/**
 *
 * @author George.Giazitzis
 */
public interface VoteServiceInterface {

    public boolean hasVoted(User voterid);

    public void insertVote(Vote vote);
}
