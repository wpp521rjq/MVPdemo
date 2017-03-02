package com.peng.mvpdemo.model;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe
 */
public class Login implements ILogin{

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        //进行登陆
        //进行模拟登录
        new Thread(){

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //进行模拟登录
                if("123456".equals(username)&&"123".equals(password)){
                    LoginModel loginModel=new LoginModel();
                    loginModel.setUsername(username);
                    loginModel.setPassword(password);
                    listener.onLoginSuccess(loginModel);
                }else{
                    listener.onFailed();
                }

            }
        }.start();
    }
}
