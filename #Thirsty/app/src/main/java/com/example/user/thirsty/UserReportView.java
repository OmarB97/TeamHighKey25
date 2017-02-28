package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class UserReportView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report_view);
        updateListView();
        registerClick();
    }

    private void updateListView() {
        Object[] list = WelcomeScreen.activeSourceReportList.printList();
        String[] writableList = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            int reportNumber;
            reportNumber = ((WaterSourceReport) list[i]).getReportNumber();
            String entry;
            entry = "Report #" + reportNumber + " submitted by " + ((WaterSourceReport) list[i]).getReporter() + " on " + ((WaterSourceReport) list[i]).getDate();
            writableList[i] = entry;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.items, writableList);

        ListView listed = (ListView) findViewById(R.id.list_view);
        listed.setAdapter(adapter);
    }

    private void registerClick() {
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent i = new Intent(UserReportView.this, UserReportViewSpecific.class);
                i.putExtra("RepNumber", position);
                startActivity(i);
            }
        });
    }
}
