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
import android.widget.Spinner;
import android.widget.Toast;

public class UserPreferenceActivity extends AppCompatActivity {

    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;

    private RadioButton option4;
    private RadioButton option5;

    private RadioButton option6;
    private RadioButton option7;
    private RadioButton option8;

    private Spinner firstPreferSpinner;
    private Spinner secondPreferSpinner;

    private Button addPreferButton;
    private Button rightButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference);

        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);

        option4 = (RadioButton) findViewById(R.id.option4);
        option5 = (RadioButton) findViewById(R.id.option4);

        option6 = (RadioButton) findViewById(R.id.option6);
        option7 = (RadioButton) findViewById(R.id.option7);
        option8 = (RadioButton) findViewById(R.id.option8);

        firstPreferSpinner = (Spinner)findViewById(R.id.first_prefer_spinner);
        secondPreferSpinner = (Spinner)findViewById(R.id.second_prefer_spinner);

        addPreferButton = (Button) findViewById(R.id.add_prefer_button);
        rightButton = (Button) findViewById(R.id.right_button);

        addPreferButton.setOnClickListener(onClickListener);
        rightButton.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.right_button:
                    Intent intent2 = new Intent(UserPreferenceActivity.this, MatchUserProgressActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.add_prefer_button:
                    Intent intent = new Intent(UserPreferenceActivity.this, SuggestPreferActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    };

}
