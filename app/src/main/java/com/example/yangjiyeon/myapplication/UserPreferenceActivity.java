package com.example.yangjiyeon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class UserPreferenceActivity extends AppCompatActivity {

    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;

    private RadioButton option4;
    private RadioButton option5;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private Spinner firstPreferSpinner;
    private Spinner secondPreferSpinner;

    private Button addPreferButton;
    private Button rightButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference);

        // 1. 선호도 조사
        // (1) 카테고리1
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);


        // (2) 카테고리2
        option4 = (RadioButton) findViewById(R.id.option4);
        option5 = (RadioButton) findViewById(R.id.option4);


        // (3) 카테고리3
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox1);


        //1순위 우선순위 선택하는 dropdown spinner
        firstPreferSpinner = (Spinner)findViewById(R.id.first_prefer_spinner);

        //2순위 우선순위 선택하는 dropdown spinner
        secondPreferSpinner = (Spinner)findViewById(R.id.second_prefer_spinner);


        //버튼 _ 건의하기
        addPreferButton = (Button) findViewById(R.id.add_prefer_button);
        //버튼 _ 매칭 시작하기
        rightButton = (Button) findViewById(R.id.right_button);

        addPreferButton.setOnClickListener(onClickListener);
        rightButton.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.add_prefer_button:
                    Intent intent = new Intent(UserPreferenceActivity.this, SuggestPreferActivity.class);
                    startActivity(intent);
                    break;


                case R.id.right_button:
                    Intent intent2 = new Intent(UserPreferenceActivity.this, MatchUserProgressActivity.class);
                    startActivity(intent2);
                    break;


                default:
                    break;
            }
        }
    };

}
