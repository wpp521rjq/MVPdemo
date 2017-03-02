package com.peng.mvpdemo.model;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe model类别，对接presenter
 */
public interface ILogin {
    public void login(String username, String password, final OnLoginListener listener);

    public interface OnLoginListener{
        void onLoginSuccess( LoginModel model);
        void onFailed();
    }
}
