package com.example.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etGasosa, etAlcool;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGasosa = findViewById(R.id.etGasosa);
        etAlcool = findViewById(R.id.etAlcool);
        tvResult = findViewById(R.id.tvResult);
    }

    public void calcular(View view){
        String gasosa = etGasosa.getText().toString();
        String alcool = etAlcool.getText().toString();

        boolean validar = this.validarCampos(alcool, gasosa);


        if(validar) {
            calcularPreco(alcool, gasosa);
        }
        else{
            tvResult.setText("Você não preencheu os preços, vacilão!");
        }


    }

    public boolean validarCampos(String precoAlcool, String precoGasolina){
        boolean validar = true;

        if(precoGasolina == null || precoGasolina.equals("")){
            validar = false;
        }
        else if(precoAlcool == null || precoAlcool.equals("")){
            validar = false;
        }

        return validar;
    }

    public void calcularPreco(String precoAlcool, String precoGasolina){
        Double gasolina = Double.parseDouble(precoGasolina);
        Double alcool = Double.parseDouble(precoAlcool);

        Double resultado = gasolina / alcool;

        if(resultado >= 0.7){
            tvResult.setText("É melhor usar Gasolina!");
        }
        else{
            tvResult.setText("Abasteça com Alcool!");
        }
    }
}
