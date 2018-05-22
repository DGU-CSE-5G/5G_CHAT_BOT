package com.example.alex.dg_chatbot.UI.Main.chat.ScheduleModel;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.dg_chatbot.R;
import com.example.alex.dg_chatbot.UI.Main.chat.NoticeModel.NoticeModel;

import org.apache.http.cookie.SM;

import java.util.ArrayList;


public class ScheduleActivity extends AppCompatActivity{

    private RecyclerView scheRecyclerview;
    private LinearLayout llBack;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<ScheduleModel> data = new ArrayList<>();
    private ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        
        llBack = findViewById(R.id.llBack);

        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        scheRecyclerview = findViewById(R.id.scheRecyclerview);
        scheRecyclerview.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        scheRecyclerview.setLayoutManager(linearLayoutManager);

        scheduleAdapter = new ScheduleAdapter(data);
        scheRecyclerview.setAdapter(scheduleAdapter);

        data.add(new ScheduleModel(0,"2018-05-22","2018-05-23","default"));
        data.add(new ScheduleModel(0,"2018-05-22","2018-05-23","default"));
        data.add(new ScheduleModel(0,"2018-05-22","2018-05-23","default"));
        data.add(new ScheduleModel(0,"2018-05-22","2018-05-23","default"));




    }

    //***********************************************
    //              ADAPTER & VIEW HOLDER
    //***********************************************
    private class ScheduleViewHolder extends RecyclerView.ViewHolder{
        
        TextView preDate, postDate, content;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            preDate = itemView.findViewById(R.id.preDate);
            postDate = itemView.findViewById(R.id.postDate);
            content = itemView.findViewById(R.id.content);
        }
    }

    private class ScheduleAdapter extends RecyclerView.Adapter{

        ArrayList<ScheduleModel> data = new ArrayList<>();

        public ScheduleAdapter(ArrayList<ScheduleModel> data) {
            this.data = data;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_list, parent, false);
            return new ScheduleViewHolder(item);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ScheduleModel scheduleModel = data.get(position);
            ScheduleViewHolder scheduleViewHolder = (ScheduleViewHolder) holder;
            
            scheduleViewHolder.preDate.setText(""+scheduleModel.getPreDate());
            scheduleViewHolder.postDate.setText(""+scheduleModel.getPostDate());
            scheduleViewHolder.content.setText(""+scheduleModel.getContent());

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }



}
