package com.peng.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.peng.mvpdemo.R;
import com.peng.mvpdemo.model.LoginModel;
import com.peng.mvpdemo.presenter.LoginPresenter;

/**
 * Created by Mr.wang
 * Date 2016/7/5
 * E-mail 1678173987@qq.com
 * Describe 登陆界面
 */
public class LoginActivity extends AppCompatActivity  implements ILoginView{

    private EditText etusername,etpassword;
    private Button btnlogin,btnclear;
    private ProgressBar progressbar;
    private LoginPresenter loginpresenter=new LoginPresenter(this);//view与presenter交互的地方

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etusername= (EditText) findViewById(R.id.edit_username);
        etpassword= (EditText) findViewById(R.id.edit_password);
        btnlogin= (Button) findViewById(R.id.login);
        btnclear= (Button) findViewById(R.id.clear);
        progressbar= (ProgressBar) findViewById(R.id.progressBar);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行登录
                loginpresenter.login();

            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行清除
                loginpresenter.clear();
            }
        });


    }

    @Override
    public String getUsername() {
        return etusername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etpassword.getText().toString().trim();
    }

    @Override
    public void clearUsername() {

        etusername.setText("");
    }

    @Override
    public void clearPassword() {
etpassword.setText("");
    }

    @Override
    public void showLoading() {
progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(LoginModel model) {
        Toast.makeText(this,"跳转",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }
}
