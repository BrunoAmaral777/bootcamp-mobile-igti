package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SettingsActivtyUtil.HabilitarFullScreen(SplashScreen.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MostrarMainActivity();
            }
        }, 2000);
    }

    private void MostrarMainActivity() {
        Intent intent = new Intent(SplashScreen.this, QuizActivity.class);
        startActivity(intent);
        finish();
    }


}