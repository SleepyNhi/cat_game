package com.example.sleepynhi.cat_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final String EMAIL="email";
    private final String PASSWORD="password";
    private final String USER = "user";
    @BindView(R.id.activity_main_em)
    EditText emailedEditText;
    @BindView(R.id.activity_main_pw)
    EditText pwEditText;

    @OnClick(R.id.activity_sharedpreference_clear)
    public void clear(View v){
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        emailedEditText.setText("");
        pwEditText.setText("");
//        shortToast("You've cleared all content");
    }

    @OnClick(R.id.activity_main_login)
    public void login(View v){
        String email = emailedEditText.getText().toString();
        String password = pwEditText.getText().toString();
        if(check(email,password)){
//            shortToast("Login Success");
            Intent intent = new Intent(this, new HomepageActivity().getClass());
            MainActivity.this.startActivity(intent);
        };
    }

    private boolean check(String email, String password){
        //ignore check
        boolean passwordCorrect = true;
        if(passwordCorrect){
            SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(EMAIL, email);
            editor.putString(PASSWORD, password);
            editor.commit();
            return true;

        }else {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        retrieveLoginInfo();

    }


    private void retrieveLoginInfo(){
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        String email = sp.getString(EMAIL,"null");
        String password = sp.getString(PASSWORD,"null");
        if (!email.equals("null")){
            emailedEditText.setText(email);
            pwEditText.setText(password);
        }
    }
}
