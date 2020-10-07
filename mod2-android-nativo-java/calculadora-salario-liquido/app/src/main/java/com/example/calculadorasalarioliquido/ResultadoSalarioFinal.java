package com.example.calculadorasalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ResultadoSalarioFinal extends AppCompatActivity {
    double salarioBruto = 0;
    int numeroDependentes = 0;
    double outrosDescontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_salario_final);

        ReceberDadosMain();



        RetornarTelaPrincipal();
    }


    private void ReceberDadosMain() {
        Intent intent = getIntent();
        if (intent != null) {
            salarioBruto = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_SALARIO_BRUTO)));
            numeroDependentes = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_NUMERO_DEPENDENTES)));
            outrosDescontos = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_OUTROS_DESCONTOS)));
        }
    }



    private void RetornarTelaPrincipal(){
        Button btnVoltarParaTelaPrincipal;
        btnVoltarParaTelaPrincipal = findViewById(R.id.btn_voltar_tela_resultado);

        btnVoltarParaTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnMain = new Intent(ResultadoSalarioFinal.this, MainActivity.class);
                startActivity(returnMain);
            }
        });
    }

}