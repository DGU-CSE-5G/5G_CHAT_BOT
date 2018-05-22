package com.example.alex.dg_chatbot.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Main.MainActivity;
import com.example.alex.dg_chatbot.Util.ResultCode;

public class SelectFavoriteActivity extends RootLogin {

    private Button btStart;
    private ResultCode resultCode;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_favorite);

        btStart = (Button) findViewById(R.id.btStart);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectFavoriteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}