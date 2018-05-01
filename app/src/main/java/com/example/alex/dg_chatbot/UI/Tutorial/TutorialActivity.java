package com.example.alex.dg_chatbot.UI.Tutorial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.alex.dg_chatbot.R;

import me.relex.circleindicator.CircleIndicator;

public class TutorialActivity extends AppCompatActivity {

    private static final int NUM_OF_FRAGMENT = 3;

    private CircleIndicator circleIndicator;
    private ViewPager tutorialViewPager;
    private MyPagerAdapter myPagerAdapter;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        circleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);
        tutorialViewPager = (ViewPager) findViewById(R.id.tutoViewPager);
        tutorialViewPager.setAdapter(myPagerAdapter);
        tutorialViewPager.setCurrentItem(0);
        circleIndicator.setViewPager(tutorialViewPager);
        circleIndicator.setBackgroundColor(R.color.blue_btn_bg_color);
        myPagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }

    View.OnClickListener movePageListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int tag = (int) view.getTag();
            tutorialViewPager.setCurrentItem(tag);
        }
    };

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Tuto1Fragment();
                case 1:
                    return new Tuto2Fragment();
                case 2:
                    return new Tuto3Fragment();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return NUM_OF_FRAGMENT;
        }
    }
}
