package com.example.alex.dg_chatbot.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Main.MainActivity;

public class SelectFavoriteActivity extends AppCompatActivity {

    private Button btStart;

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
