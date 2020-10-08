package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivtyUtil.HabilitarFullScreen(ResultsActivity.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_results);


        RetornarMainActivity();
    }

    private void RetornarMainActivity() {
        Button btnRetornarParaTelaPrincipal;
        btnRetornarParaTelaPrincipal = findViewById(R.id.btnReiniciar);

        btnRetornarParaTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnMain = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(returnMain);
            }
        });
    }
}