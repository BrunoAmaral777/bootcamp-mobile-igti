package com.example.quizandroid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivtyUtil extends AppCompatActivity {

    public static void HabilitarFullScreen(Activity activity){
        // remove title
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
