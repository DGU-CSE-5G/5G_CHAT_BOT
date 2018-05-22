package com.example.alex.dg_chatbot.Util;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Login.LoginActivity;
import com.example.alex.dg_chatbot.UI.Login.RootLogin;
import com.example.alex.dg_chatbot.UI.Login.SelectFavoriteActivity;
import com.example.alex.dg_chatbot.UI.Login.SignInActivity;
import com.example.alex.dg_chatbot.UI.Login.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import junit.framework.Test;

public class TestActivity extends RootLogin {

    private FrameLayout flAnonyLogin;
    private FrameLayout flEmailSignUp;
    private FrameLayout flEmailLogin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        flAnonyLogin = findViewById(R.id.flAnonyLogin);
        flEmailSignUp = findViewById(R.id.flEmailSignUp);
        flEmailLogin = findViewById(R.id.flEmailLogin);

        firebaseAuth = FirebaseAuth.getInstance();

        flEmailSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        flAnonyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anonymousSignUp();
            }
        });

        flEmailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }

    public void anonymousSignUp(){
        showPD();
        firebaseAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //성공 -> 회원 정보 획득
                    FirebaseUser user = getUser();
                    if(user != null){
                        Log.i("Login", user.getUid());
//                        Log.i("Login", user.getEmail());
                    }

                    Toast.makeText(TestActivity.this, "익명 계정 생성 성공", Toast.LENGTH_LONG).show();
                    startSelectActivity();
                }else{
                    Toast.makeText(TestActivity.this, "익명 계정 생성 실패", Toast.LENGTH_LONG).show();
                }
                stopPD();
            }
        });
    }

    public void startSelectActivity(){
        Intent intent = new Intent(TestActivity.this, SelectFavoriteActivity.class);
        startActivity(intent);
    }
}
