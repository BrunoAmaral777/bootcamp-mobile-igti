package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivtyUtil.HabilitarFullScreen(QuizActivity.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_quiz);

        ClickBtnVerdadeiro();
        ClickBtnFalso();
        MostrarResultsActivity();
    }

    private void ListaQuestoesQuiz(){
        Questions[] mQuestions = new Questions[]{
                new Questions(R.string.question_01, true),
                new Questions(R.string.question_02, false),
                new Questions(R.string.question_03, true),
                new Questions(R.string.question_04, true),
                new Questions(R.string.question_05, true),
                new Questions(R.string.question_06, false),
                new Questions(R.string.question_07, true),
                new Questions(R.string.question_08, true),
        };

    }

    private void ClickBtnVerdadeiro(){
        Button btnVerdadeiro;
        btnVerdadeiro = findViewById(R.id.btnVerdadeiro);

        btnVerdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void ClickBtnFalso(){
        Button btnFalso;
        btnFalso = findViewById(R.id.btnFalso);

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void MostrarResultsActivity() {
        Button btnRetornarParaTelaPrincipal;
        btnRetornarParaTelaPrincipal = findViewById(R.id.btnMain);

        btnRetornarParaTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnMain = new Intent(QuizActivity.this, ResultsActivity.class);
                startActivity(returnMain);
            }
        });
    }
}