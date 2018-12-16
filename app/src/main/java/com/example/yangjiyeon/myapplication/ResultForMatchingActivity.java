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


        //매칭 요청 보내면 팝업을 띄우는게 간단하겠지? '친구에게 요청 문자를 보냈습니다. 친구가 수락하면 채팅방이 개설됩니다.' + 확인누르면 팝업이 사라지는 버튼


//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ResultForMatchingActivity.this, ????.class);
//                startActivity(intent);
//            }
//        };


    }
}