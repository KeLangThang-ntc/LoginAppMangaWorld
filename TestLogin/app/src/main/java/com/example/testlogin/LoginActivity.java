package com.example.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testlogin.API.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnSignUp;
    private User mUser;

    private List<User> mlistUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        mlistUser = new ArrayList<>();
        btnSignUp = findViewById(R.id.btn_signup);
        //GetListUsers();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickLogin();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void ClickLogin() {
        String userName = edtUserName.getText().toString().trim();
        String passWord = edtPassword.getText().toString().trim();

        if(mlistUser == null || mlistUser.isEmpty()){
            return;
        }

        boolean isHasUser = false;
        for (User user : mlistUser){
            if(userName.equals(user.getUserName()) && passWord.equals(user.getPassWord())){
                isHasUser = true;
                mUser = user;
                break;
            }
        }
        if(isHasUser){
            //Login successfully
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(LoginActivity.this, "Username or PassWord Invalid",Toast.LENGTH_SHORT).show();
        }
    }

    private void GetListUsers(){
        APIService.apiService.getListUser("#key").enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mlistUser = response.body();
                Log.e("list Users", mlistUser.size() + "");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Call API Error!" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}