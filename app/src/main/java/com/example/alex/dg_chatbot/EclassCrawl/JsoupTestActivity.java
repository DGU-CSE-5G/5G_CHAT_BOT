package com.example.alex.dg_chatbot.EclassCrawl;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Main.MainActivity;
import com.example.alex.dg_chatbot.Util.AlertUtil;

import org.json.JSONObject;

import java.io.IOException;



public class JsoupTestActivity extends AppCompatActivity {

    private static String portalDG = "https://cafe.naver.com";

    private TextView output;
    private EditText userId;
    private EditText userPwd;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoup_test);

        output = findViewById(R.id.tv_ouptut);
        userId = findViewById(R.id.userId);
        userPwd = findViewById(R.id.userPwd);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String id = userId.getText().toString();
                String pwd = userPwd.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertUtil.getInstance().showSuccessPopup(getBaseContext(),
                                        "json불러오기 성공","");
                                Intent intent = new Intent(JsoupTestActivity.this, MainActivity.class);
                                JsoupTestActivity.this.startActivity(intent);
                                finish();
                            }else{
                                AlertUtil.getInstance().showErrorPopup(getBaseContext(),
                                        "json불러오기 실패", "다시 입력해주세요");
                            }
                        } catch (Exception e) {

                        }
                    }
                };



            }
        });

//        NetworkTask networkTask = new NetworkTask(portalDG, null);
//        networkTask.execute();

    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result=""; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            try {
                result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            output.setText(s);
        }
    }
}
