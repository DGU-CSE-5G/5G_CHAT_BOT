package com.example.alex.dg_chatbot.UI.Main.settings;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Tutorial.TutorialActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private FirebaseAuth firebaseAuth;

    private LinearLayout llPush;
    private LinearLayout llNotice;
    private LinearLayout llQnA;
    private LinearLayout llAppInfo;
    private LinearLayout llLogout;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_setting, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        llPush = view.findViewById(R.id.llPush);
        llNotice = view.findViewById(R.id.llNotice);
        llQnA = view.findViewById(R.id.llQnA);
        llAppInfo = view.findViewById(R.id.llAppInfo);
        llLogout = view.findViewById(R.id.llLogout);

        llPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llQnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llAppInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent intent = new Intent(getActivity().getBaseContext(), TutorialActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
