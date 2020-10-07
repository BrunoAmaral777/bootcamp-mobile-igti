package com.example.calculadorasalarioliquido;

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

public class ResultadoSalarioFinal extends AppCompatActivity {
    double salarioBruto = 0;
    int numeroDependentes = 0;
    double outrosDescontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_salario_final);

        ReceberDadosMain();

        ExibirDadosNaTela();

        RetornarParaTelaPrincipal();
    }


    private void ReceberDadosMain() {
        Intent intent = getIntent();
        if (intent != null) {
            salarioBruto = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_SALARIO_BRUTO)));
            numeroDependentes = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_NUMERO_DEPENDENTES)));
            outrosDescontos = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.VALOR_OUTROS_DESCONTOS)));
        }
    }


    private void ExibirDadosNaTela(){
        TextView textSalarioBruto;
        TextView textINSS;
        TextView textIRRF;
        TextView textOutrosDescontos;

        TextView textSalarioLiquido;
        TextView textPorcentagemDesconto;

        textSalarioBruto = findViewById(R.id.text_salario_bruto_resultado);
        textINSS = findViewById(R.id.text_inss_resultado);
        textIRRF = findViewById(R.id.text_irrf_resultado);
        textOutrosDescontos = findViewById(R.id.text_outros_descontos_resultado);

        textSalarioLiquido = findViewById(R.id.text_salario_liquido_resultado);
        textPorcentagemDesconto = findViewById(R.id.text_desconto_porcentagem_resultado);

        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));

        textSalarioBruto.setText(formatoBR.format(salarioBruto));
        textINSS.setText(formatoBR.format(CalculoSalarioUtil.CalculoDescontoInss(salarioBruto)));
        textIRRF.setText(formatoBR.format(CalculoSalarioUtil.CalculoIrrf(salarioBruto, numeroDependentes)));
        textOutrosDescontos.setText(formatoBR.format(outrosDescontos));
        textSalarioLiquido.setText(formatoBR.format(CalculoSalarioUtil.SalarioLiquido(salarioBruto,numeroDependentes,outrosDescontos)));
        textPorcentagemDesconto.setText(CalculoSalarioUtil.PorcentagemDescontosTotais(salarioBruto,numeroDependentes,outrosDescontos));
    }


    private void RetornarParaTelaPrincipal(){
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