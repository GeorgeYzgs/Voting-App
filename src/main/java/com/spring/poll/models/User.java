/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poll.models;

import com.spring.poll.dtos.RegisterUserDto;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author George.Giazitzis
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByUserfirstname", query = "SELECT u FROM User u WHERE u.userfirstname = :userfirstname"),
    @NamedQuery(name = "User.findByUserlastname", query = "SELECT u FROM User u WHERE u.userlastname = :userlastname"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByUserpassword", query = "SELECT u FROM User u WHERE u.userpassword = :userpassword")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 40)
    @Column(name = "USERFIRSTNAME")
    private String userfirstname;
    @Size(max = 40)
    @Column(name = "USERLASTNAME")
    private String userlastname;
    @Size(max = 40)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 60)
    @Column(name = "USERPASSWORD")
    private String userpassword;
    @JoinColumn(name = "ROLEID", referencedColumnName = "ROLEID")
    @ManyToOne
    private Role roleid;
    @OneToMany(mappedBy = "candidateid")
    private Collection<Vote> voteCollection;
    @OneToMany(mappedBy = "voterid")
    private Collection<Vote> voteCollection1;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(RegisterUserDto dto) {
        this.userfirstname = dto.getFirstname();
        this.userlastname = dto.getLastname();
        this.username = dto.getUsername();
        this.roleid = dto.getRole();
        this.userpassword = dto.getPassword();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection1() {
        return voteCollection1;
    }

    public void setVoteCollection1(Collection<Vote> voteCollection1) {
        this.voteCollection1 = voteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.poll.models.User[ userid=" + userid + " ]";
    }

}
