package com.example.yangjiyeon.myapplication;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class ResultForMatchingActivity extends AppCompatActivity {

    private OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_for_matching);

        Button button_for_travel_info = (Button) findViewById(R.id.button_for_travel_info);
        button_for_travel_info.setOnClickListener(onClickListener);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultForMatchingActivity.this, TravelInfoActivity.class);
                startActivity(intent);
            }
        };


    }
}