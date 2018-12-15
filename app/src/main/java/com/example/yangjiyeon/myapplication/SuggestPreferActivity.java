package com.example.yangjiyeon.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuggestPreferActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText contentEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_prefer);

        submitButton = (Button) findViewById(R.id.submit_button);
        contentEditText = (EditText) findViewById(R.id.content_edit_text);

        submitButton.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.submit_button:
                    sendData();
                    finish();
                    break;
            }
        }
    };

    private void sendData() {
        contentEditText.getText().toString(); //TODO : USE DATA
    }
}
