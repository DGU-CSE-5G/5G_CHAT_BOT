package com.example.alex.dg_chatbot.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserId;
    private EditText etUserPwd;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserId = (EditText) findViewById(R.id.etUserId);
        etUserPwd = (EditText) findViewById(R.id.etUserPwd);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SelectFavoriteActivity.class);
                intent.putExtra("userId", etUserId.getText().toString());
                intent.putExtra("userPwd", etUserPwd.getText().toString());
                startActivity(intent);
            }
        });
    }


}
