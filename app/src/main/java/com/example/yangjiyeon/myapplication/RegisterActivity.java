package com.example.yangjiyeon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //xml에서 디자인한 각 뷰들을 id값으로 찾아내서 id와 같은 이름의 변수에 담음
    EditText idText = (EditText) findViewById(R.id.idText);
    EditText passwordText = (EditText) findViewById(R.id.passwordText);
    EditText nameText = (EditText) findViewById(R.id.nameText);

    Button registerButton = (Button) findViewById(R.id.registerButton);

}
