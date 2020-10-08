package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivtyUtil.HabilitarFullScreen(MainActivity.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_main);

        MostrarResultsActivity();
    }


    private void MostrarResultsActivity() {
        Button btnRetornarParaTelaPrincipal;
        btnRetornarParaTelaPrincipal = findViewById(R.id.btnMain);

        btnRetornarParaTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnMain = new Intent(MainActivity.this, ResultsActivity.class);
                startActivity(returnMain);
            }
        });
    }
}