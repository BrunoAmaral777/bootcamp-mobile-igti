package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private int mCurrentIndex = 0;
    TextView textQuestion;

    Questions[] mQuestionsArray = new Questions[]{
            new Questions(R.string.question_01, true),
            new Questions(R.string.question_02, false),
            new Questions(R.string.question_03, true),
            new Questions(R.string.question_04, true),
            new Questions(R.string.question_05, true),
            new Questions(R.string.question_06, false),
            new Questions(R.string.question_07, true),
            new Questions(R.string.question_08, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivtyUtil.HabilitarFullScreen(QuizActivity.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_quiz);

        QuestaoAtual();
        ClickBtnVerdadeiro();
        ClickBtnFalso();

    }

    private void QuestaoAtual(){
        textQuestion = findViewById(R.id.textPergunta);
        final int question = mQuestionsArray[mCurrentIndex].getIdResposta();
        textQuestion.setText(question);
    }


    private void ClickBtnVerdadeiro(){
        Button btnVerdadeiro;
        btnVerdadeiro = findViewById(R.id.btnVerdadeiro);

        btnVerdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarResposta(true);
                ValidarChegouNoFinal();
            }
        });

    }

    private void ClickBtnFalso(){
        Button btnFalso;
        btnFalso = findViewById(R.id.btnFalso);

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarResposta(false);
                ValidarChegouNoFinal();
            }
        });
    }

    private void ValidarResposta(boolean userClick) {
        Boolean resposta = mQuestionsArray[mCurrentIndex].isRespostaCorreta();
        if (userClick == resposta){
            Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }

    private void ValidarChegouNoFinal() {
        mCurrentIndex = mCurrentIndex + 1;
        if (mCurrentIndex == mQuestionsArray.length){
            Intent returnMain = new Intent(QuizActivity.this, ResultsActivity.class);
            startActivity(returnMain);
        } else {
            int novapergunta = mQuestionsArray[mCurrentIndex].getIdResposta();
            textQuestion.setText(novapergunta);
        }
    }
}