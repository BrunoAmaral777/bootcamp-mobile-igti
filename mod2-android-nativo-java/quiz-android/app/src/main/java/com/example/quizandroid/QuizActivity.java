package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private int mCurrentIndex = 0;
    private int totalQuestoes = 0;
    private int totalRespostasCorretas = 0;
    public static final String VALOR_TOTAL_ACERTOS = "valorTotalAcertos";
    public static final String TOTAL_QUESTOES = "totalQuestoesQuiz";


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
        //setTheme(R.style.AppTheme); //Define o Style
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        QuestaoAtual();
        ClickBtnVerdadeiro();
        ClickBtnFalso();

    }

    private void QuestaoAtual(){
        textQuestion = findViewById(R.id.textPergunta);
        final int question = mQuestionsArray[mCurrentIndex].getIdQuestao();
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
        final Toast toastResposta;
        Boolean resposta = mQuestionsArray[mCurrentIndex].isRespostaCorreta();
        if (userClick == resposta){
            totalRespostasCorretas = totalRespostasCorretas + 1; // soma de respostas corretas
            toastResposta = Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT);
        } else{
            toastResposta = Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
        }
        toastResposta.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 250);
        toastResposta.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toastResposta.cancel();
            }
        }, 750);
    }


    private void ValidarChegouNoFinal() {
        mCurrentIndex = mCurrentIndex + 1;
        if (mCurrentIndex == mQuestionsArray.length){
            totalQuestoes = Integer.parseInt(String.valueOf(mQuestionsArray.length));
            Intent intentReturnMain = new Intent(QuizActivity.this, ResultsActivity.class);
            intentReturnMain.putExtra(VALOR_TOTAL_ACERTOS, totalRespostasCorretas);
            intentReturnMain.putExtra(TOTAL_QUESTOES, totalQuestoes);
            startActivity(intentReturnMain);
        } else {
            int novapergunta = mQuestionsArray[mCurrentIndex].getIdQuestao();
            textQuestion.setText(novapergunta);
        }
    }
}