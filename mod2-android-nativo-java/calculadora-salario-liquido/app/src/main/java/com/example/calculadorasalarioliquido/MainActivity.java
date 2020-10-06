package com.example.calculadorasalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //    public void CliqueBtnCalcular(){
//
//        final EditText edtSalarioBrutoMain = (EditText) findViewById(R.id.edtSalarioBrutoMain);
//        final EditText edtNumDependentesMain = (EditText) findViewById(R.id.edtNumDependentesMain);
//        final EditText edtOutrosDescontosMain = (EditText) findViewById(R.id.edtOutrosDescontosMain);
//        Button btnCalcularValoresMain = (Button) findViewById(R.id.btnCalcularValoresMain);
//
//        final float floatSalarioBrutoMain = Float.parseFloat(edtSalarioBrutoMain.getText().toString());
//        final float floatNumDependentesMain = Float.parseFloat(edtNumDependentesMain.getText().toString());
//        final float floatOutrosDescontosMain = Float.parseFloat(edtOutrosDescontosMain.getText().toString());
//
//        btnCalcularValoresMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentMain = new Intent(MainActivity.this, ResultadoFinal.class);
//                intentMain.putExtra("valorSalarioBrutoMain", floatSalarioBrutoMain);
//                intentMain.putExtra("valorSalarioBrutoMain", floatNumDependentesMain);
//                intentMain.putExtra("valorSalarioBrutoMain", floatOutrosDescontosMain);
//                startActivity(intentMain);
//            }
//        });
//    }

}

