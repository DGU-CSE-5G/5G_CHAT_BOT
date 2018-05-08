package com.example.alex.dg_chatbot.UI.Login;

import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alex.dg_chatbot.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends RootLogin {

    private EditText etUserNewID;
    private EditText etUserNewPwd;
    private CheckBox cbAgree;
    private Button btNewSignUp;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //sign in
                }else{
                    //sign out
                }
            }
        };

        firebaseAuth = FirebaseAuth.getInstance();
        etUserNewID = findViewById(R.id.etUserNewID);
        etUserNewPwd = findViewById(R.id.etUserNewPwd);
        cbAgree = findViewById(R.id.cbAgree);
        btNewSignUp = findViewById(R.id.btNewSignUp);

        btNewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbAgree.isChecked()){
                    emailSignUp();
                }else{
                    Toast.makeText(SignUpActivity.this, "약관에 동의해주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }

    public void emailSignUp(){
        String email = this.etUserNewID.getText().toString();
        String pwd = this.etUserNewPwd.getText().toString();
        showPD();
        firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.i("signup","success? : " + task.isSuccessful());

                if(!task.isSuccessful())
                    Toast.makeText(SignUpActivity.this, "failed", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(SignUpActivity.this, "success", Toast.LENGTH_LONG).show();
                    finish();
                }


                stopPD();
            }

        });
    }
}
