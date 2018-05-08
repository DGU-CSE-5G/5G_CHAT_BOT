package com.example.alex.dg_chatbot.UI.Main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Tutorial.TutorialActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private Button btLogout;
    private FirebaseAuth firebaseAuth;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_setting, container, false);
        btLogout = view.findViewById(R.id.btLogout);
        firebaseAuth = FirebaseAuth.getInstance();

        btLogout.setOnClickListener(new View.OnClickListener() {
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
