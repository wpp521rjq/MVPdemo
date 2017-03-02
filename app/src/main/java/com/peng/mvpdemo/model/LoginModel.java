package com.peng.mvpdemo.model;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe 登陆的model
 */
public class LoginModel {
    private String username;//用户名
    private String password;//密码

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
