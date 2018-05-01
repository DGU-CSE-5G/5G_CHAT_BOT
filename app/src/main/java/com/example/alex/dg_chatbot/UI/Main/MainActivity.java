package com.example.alex.dg_chatbot.UI.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alex.dg_chatbot.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: //메인 홈 화면
                    fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment()).commit();
                    Log.i("navi","home selected");
                    return true;

                case R.id.navigation_chat: //챗봇 화면
                    fragmentManager.beginTransaction().replace(R.id.flContent, new ChatFragment()).commit();
                    Log.i("navi","chat selected");
                    return true;

                case R.id.navigation_setting: //세팅 화면
                    fragmentManager.beginTransaction().replace(R.id.flContent, new SettingFragment()).commit();
                    Log.i("navi", "setting selected");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToHome();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    public void switchToHome(){
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment()).commitNow();
    }

    public void switchToChat(){
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment()).commitNow();
    }

    public void switchToSetting(){
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment()).commitNow();
    }

    public void switchToFrament(int itemId){
        switch (itemId) {
            case R.id.navigation_home:
                Log.i("navi","home method selected");
                fragmentManager.beginTransaction()
                        .replace(R.id.flContent, new HomeFragment()).commitNow();

            case R.id.navigation_chat:
                Log.i("navi","chat method selected");
                fragmentManager.beginTransaction()
                        .replace(R.id.flContent, new ChatFragment()).commitNow();

            case R.id.navigation_setting:
                Log.i("navi","setting method selected");
                fragmentManager.beginTransaction()
                        .replace(R.id.flContent, new SettingFragment()).commitNow();
        }
    }



}
