package com.example.hello.response;

import com.example.hello.myBatis.po.User;

public class LoginResponse {
    private String info;
    private User user;

    public LoginResponse(String info, User user) {
        this.info = info;
        this.user = user;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
