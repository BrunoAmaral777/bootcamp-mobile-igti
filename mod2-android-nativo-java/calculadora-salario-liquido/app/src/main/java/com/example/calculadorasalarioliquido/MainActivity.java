package com.example.calculadorasalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String VALOR_SALARIO_BRUTO = "valorSalarioBrutoMain";
    public static final String VALOR_NUMERO_DEPENDENTES = "valorNumDependentesMain";
    public static final String VALOR_OUTROS_DESCONTOS = "valorOutrosDescontosMain";

    EditText edtSalarioBrutoMain;
    EditText edtNumDependentesMain;
    EditText edtOutrosDescontosMain;
    Button btnCalcularValoresMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CliqueBtnCalcular();
    }

    private void CliqueBtnCalcular(){

        edtSalarioBrutoMain = findViewById(R.id.edt_salario_bruto_main);
        edtNumDependentesMain = findViewById(R.id.edt_numero_dependente_main);
        edtOutrosDescontosMain = findViewById(R.id.edt_outros_dependentes_main);
        btnCalcularValoresMain = findViewById(R.id.btn_calcular_tela_main);

        btnCalcularValoresMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (edtSalarioBrutoMain.getText().length() > 0) {
                Intent intentMain = new Intent(MainActivity.this, ResultadoSalarioFinal.class);
                intentMain.putExtra(VALOR_SALARIO_BRUTO, edtSalarioBrutoMain.getText().toString());
                intentMain.putExtra(VALOR_NUMERO_DEPENDENTES, edtNumDependentesMain.getText().toString().equals("") ? "0" : edtNumDependentesMain.getText().toString());
                intentMain.putExtra(VALOR_OUTROS_DESCONTOS, edtOutrosDescontosMain.getText().toString().equals("") ? "0" : edtOutrosDescontosMain.getText().toString());
                startActivity(intentMain);

            } else {
                new AlertDialog.Builder(MainActivity.this).setTitle("Erro")
                        .setMessage("Por favor, preencha ao menos o campo de 'Salário Bruto'.")
                        .setNeutralButton("OK", null).show();
            }
            }
        });
    }
}

