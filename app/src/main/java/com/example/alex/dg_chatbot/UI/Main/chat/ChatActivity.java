package com.example.alex.dg_chatbot.UI.Main.chat;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.dg_chatbot.R;
import com.google.gson.JsonElement;

import java.nio.channels.AsynchronousChannel;
import java.util.Map;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class ChatActivity extends AppCompatActivity {

    private static final String ACCESS_TOKEN = "2aa32e7cdfb44da8b90ad5ca56141b01";

    private TextView tvResult;
    private EditText etSendMsg;
    private Button btSend;

    final AIRequest aiRequest = new AIRequest();
    final ai.api.android.AIConfiguration config = new ai.api.android.AIConfiguration(ACCESS_TOKEN,
            ai.api.android.AIConfiguration.SupportedLanguages.English,
            ai.api.android.AIConfiguration.RecognitionEngine.System);

    final AIDataService aiDataService = new AIDataService(config);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tvResult = findViewById(R.id.tvResult);
        etSendMsg = findViewById(R.id.etSendMsg);
        btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            String sendMsg = "";
            @Override
            public void onClick(View view) {
                sendMsg = etSendMsg.getText().toString();
                aiRequest.setQuery(sendMsg);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                requestQuery();
                            }
                        });
                    }
                }).start();
            }
        });


    }

    public void requestQuery(){
        new AsyncTask<AIRequest, Void, AIResponse>(){

            @Override
            protected AIResponse doInBackground(AIRequest... aiRequests) {
                final AIRequest request = aiRequests[0];
                try{
//                    tvResult.setText(""+request);
                    final AIResponse aiResponse = aiDataService.request(request);
                } catch (AIServiceException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(AIResponse aiResponse) {
                super.onPostExecute(aiResponse);
                if(aiResponse != null){
                    Result result = aiResponse.getResult();
                    String paramString = "";
                    if(result.getParameters() != null && !result.getParameters().isEmpty()){
                        for(final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()){
                            paramString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
                        }
                    }


                    tvResult.setText("Query : " + result.getResolvedQuery() +
                            "\nAction : " + result.getAction()+
                            "\nParam : " + paramString+
                            "\nspeech : " + result.getFulfillment().getSpeech());



//                    tvResult.setText(aiResponse.getResult() + "");
                }else{
                    tvResult.setText("error");
                }
            }
        }.execute(aiRequest);

    }
}
