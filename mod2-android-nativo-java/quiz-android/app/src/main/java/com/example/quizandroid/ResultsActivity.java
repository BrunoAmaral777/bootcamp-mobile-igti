package com.example.quizandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class ResultsActivity extends AppCompatActivity {

    double resultadoTotalAcertos;
    double resultadoTotalQuestoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingsActivtyUtil.HabilitarFullScreen(ResultsActivity.this);
        getSupportActionBar().hide(); // Remove a ActionBar da Activity
        setContentView(R.layout.activity_results);

        ReceberDadosMain();

        ExibirDadosNaTela();

        RetornarMainActivity();
    }

    private void ReceberDadosMain() {
        Intent intentResultado = getIntent();
        if (intentResultado != null) {
            resultadoTotalAcertos = intentResultado.getIntExtra(QuizActivity.VALOR_TOTAL_ACERTOS, 0);
            resultadoTotalQuestoes = intentResultado.getIntExtra(QuizActivity.TOTAL_QUESTOES, 0);
        }
    }

    private void ExibirDadosNaTela(){
        TextView textTotal;
        String ResultadoFinal = "0";
        textTotal = findViewById(R.id.textResultadoPorcentagem);
        ResultadoFinal = String.valueOf((resultadoTotalAcertos / resultadoTotalQuestoes) * 100) + "%";
        textTotal.setText(ResultadoFinal);
    }

    private void RetornarMainActivity() {
        Button btnRetornarParaTelaPrincipal;
        btnRetornarParaTelaPrincipal = findViewById(R.id.btnReiniciar);

        btnRetornarParaTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnMain = new Intent(ResultsActivity.this, QuizActivity.class);
                startActivity(returnMain);
            }
        });
    }
}