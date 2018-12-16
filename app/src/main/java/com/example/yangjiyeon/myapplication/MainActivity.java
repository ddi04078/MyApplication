package com.example.yangjiyeon.myapplication;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);*/

//
//        Intent intent = new Intent(this, TravelInfoActivity.class);
//        startActivity(intent);


        Button button_for_travel_info = (Button) findViewById(R.id.button_for_travel_info);
        button_for_travel_info.setOnClickListener(onClickListener);




        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TravelInfoActivity.class);
                startActivity(intent);
            }
        };
    }
}


/*
* 1. 데이터베이스
*   MySQLiteOpenHelper.java : 안드로이드에서 sqlite 데이터베이스 쉽게 생성가능하게 한 클래스
*   loginActivity.java에 데이터베이스 조작, 관리에 관한 코드 넣었는데..이게 회원가입에 들어가야할지?
*   + http://bitsoul.tistory.com/118 보고 sqlite 짰는데, chap12.데이터 관리 코드 보고 수정하기
*    (MySqliteOpenhelper 말고 liginactivity 에 있는 코드만 확인하면됨)
*
* 2. 시작페이지를 loginActivity.java에서 시작하고, 로그인 완료하면 메인액티비티 뜨게 해야함
*
* 3. 화면 글자가 왜 뭉치는 현상이 발생하는건지? 액티비티
*
* 4. 안드로이드 깃 사용 : https://blog.gomsang.com/36
* */
