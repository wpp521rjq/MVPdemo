package com.peng.mvpdemo.presenter;

import android.os.Handler;

import com.peng.mvpdemo.model.ILogin;
import com.peng.mvpdemo.model.Login;
import com.peng.mvpdemo.model.LoginModel;
import com.peng.mvpdemo.view.ILoginView;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe  登陆的presenter
 */
public class LoginPresenter {

    private ILoginView loginView;//进行view的控制
    private ILogin login;//链接model
    private Handler handler=new Handler();
    public LoginPresenter(ILoginView iLoginView){
        //构造器进行初始化对象的时候进行初始化数据使用的，
        this.loginView=iLoginView;
        login=new Login();
    }

    /**
     * 登陆
     */
    public  void login(){
        loginView.showLoading();//显示loading
        login.login(loginView.getUsername(), loginView.getPassword(), new ILogin.OnLoginListener() {
            @Override
            public void onLoginSuccess(final LoginModel model) {
                //登陆成功进行更新 ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(model);
                   loginView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailed() {

                //同样进行更新ui
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }
    /**
     * 进行clear
     */
    public void clear(){
        loginView.clearUsername();
        loginView.clearPassword();
    }
}
