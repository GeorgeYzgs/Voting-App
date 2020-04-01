/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author George.Giazitzis
 */
@Entity
@Table(name = "vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByVoteid", query = "SELECT v FROM Vote v WHERE v.voteid = :voteid"),
    @NamedQuery(name = "Vote.findByRating", query = "SELECT v FROM Vote v WHERE v.rating = :rating"),
    @NamedQuery(name = "Vote.findByDatetime", query = "SELECT v FROM Vote v WHERE v.datetime = :datetime")})
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOTEID")
    private Integer voteid;
    @Column(name = "RATING")
    private Integer rating;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "CANDIDATEID", referencedColumnName = "USERID")
    @ManyToOne
    private User candidateid;
    @JoinColumn(name = "VOTERID", referencedColumnName = "USERID")
    @ManyToOne
    private User voterid;

    public Vote() {
    }

    public Vote(Integer voteid) {
        this.voteid = voteid;
    }

    public Vote(User voterid, User candidateid) {
        this.voterid = voterid;
        this.candidateid = candidateid;
        this.rating = 5;  //set to 5, might add voting range options later
        this.datetime = new Date();
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(User candidateid) {
        this.candidateid = candidateid;
    }

    public User getVoterid() {
        return voterid;
    }

    public void setVoterid(User voterid) {
        this.voterid = voterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteid != null ? voteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.voteid == null && other.voteid != null) || (this.voteid != null && !this.voteid.equals(other.voteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.poll.models.Vote[ voteid=" + voteid + " ]";
    }

}
