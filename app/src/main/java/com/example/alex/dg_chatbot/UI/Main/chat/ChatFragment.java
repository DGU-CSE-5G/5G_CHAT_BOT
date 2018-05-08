package com.example.alex.dg_chatbot.UI.Main.chat;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.dg_chatbot.R;
import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIDataService;
import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment{

    private Button btGoChat;

    public ChatFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_chat, container, false);
        btGoChat = view.findViewById(R.id.btGoChat);
        btGoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), ChatActivity.class);
                startActivity(intent);
            }
        });


//        aiRequest.setQuery("1월 학사일정 알려줘");
//        new AsyncTask<AIRequest, Void, AIResponse>(){
//            @Override
//            protected AIResponse doInBackground(AIRequest... aiRequests) {
//                final AIRequest request = aiRequests[0];
//                try {
////                    tvResult.setText("" + aiRequests[0]);
//                    final AIResponse aiResponse = aiDataService.request(request);
//                    return aiResponse;
//                } catch (AIServiceException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(AIResponse aiResponse) {
//                super.onPostExecute(aiResponse);
//
//                if(aiResponse != null){
//                    Result result = aiResponse.getResult();
//                    String paramString = "";
//                    if(result.getParameters() != null && !result.getParameters().isEmpty()){
//                        for(final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()){
//                            paramString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
//                        }
//                    }
//
//
//                    tvResult.setText("Query : " + result.getResolvedQuery() +
//                            "\nAction : " + result.getAction()+
//                            "\nParam : " + paramString+
//                            "\nspeech : " + result.getFulfillment().getSpeech());
//
//
//
////                    tvResult.setText(aiResponse.getResult() + "");
//                }else{
//                    tvResult.setText("error");
//                }
//            }
//        }.execute(aiRequest);


        return view;
    }






}
