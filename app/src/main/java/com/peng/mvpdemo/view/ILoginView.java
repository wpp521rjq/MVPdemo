package com.peng.mvpdemo.view;

import com.peng.mvpdemo.model.LoginModel;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe  登陆接口进行view登陆的接入
 */
public interface ILoginView {
    String getUsername();//得到username
    String getPassword();//得到password
    void clearUsername();//清除username
    void clearPassword();//清除password
    void showLoading();//显示loading
    void hideLoading();//隐藏loading
    void toMainActivity(LoginModel model);//跳转到mainActivity
    void showFailedError();//显示错误信息
}
