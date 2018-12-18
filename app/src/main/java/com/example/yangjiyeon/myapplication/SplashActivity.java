package com.example.yangjiyeon.myapplication;


import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set your splash_screen layout
        setContentView(R.layout.splash_screen);

        // create a new Thread
        new Handler().postDelayed(new Runnable() {
            public void run() {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        },800);
    }
}