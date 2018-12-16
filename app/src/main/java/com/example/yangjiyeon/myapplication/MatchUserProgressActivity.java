package com.example.yangjiyeon.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.net.URL;

public class MatchUserProgressActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_user_progress);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setProgress(0);

        setProgressBar(0);
    }


    private void setProgressBar(final int progress) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                if(progress >= 100) {
                    Intent intent = new Intent(MatchUserProgressActivity.this, ResultForMatchingActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                progressBar.setProgress(progress);
                setProgressBar(progress + 1);
            }
        };

        new Handler().postDelayed(task, 25);
    }
}
