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
        setContentView(R.layout.activity_splash_screen);
        SplashScreenTimer();
    }

    private void SplashScreenTimer(){
        //Define a Splash Screen para mostrar apenas na primeira vez
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        Boolean firstLogin = preferences.getBoolean("FIRST", true);

        if(firstLogin){
            editor.putBoolean("FIRST", false);
            editor.commit();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    MostrarMainActivity();
                }
            }, 2000);
        }else{
            MostrarMainActivity();
        }
    }

    private void MostrarMainActivity() {
        startActivity(new Intent(SplashScreen.this, QuizActivity.class));
    }

}