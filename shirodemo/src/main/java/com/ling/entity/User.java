package com.ling.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Lian on 08/25/2017.
 */
public class User implements Serializable{
    private Long id;
    private String email;
    private String userName;
    private String password;
    private String nickName;
    private LocalDateTime regTime;

    private Set<Role> roles;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
