package com.jesuscristo.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText gasolina;
    private TextInputEditText alcool;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolina    = findViewById(R.id.editPrecoGasolina);
        alcool      = findViewById(R.id.editPrecoAlcool);
        resultado   = findViewById(R.id.textResultado);
    }

    public void calcularPrecos(View v){

        // recuperando os valores
       String precoGasolina = gasolina.getText().toString();
       String precoAlcool = alcool.getText().toString();

       // validação dos campos
        boolean valido = validacao(precoGasolina, precoAlcool);

        if(valido){
            resultado.setText("Preencha todos os campos");

        }else{
            // convertando os valores para outro tipo de dados
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double valorAlcool = Double.parseDouble(precoAlcool);

            // calculo para saber se e melhor gasolina ou alcool
            if(valorAlcool / valorGasolina >= 0.7){
                resultado.setText("Melhor usar Gasolina :)");

            }else{

                resultado.setText("Melhor usar Álcool :)");
            }


        }
    }

    public boolean validacao(String PrecoGasolina, String PrecoAlcool){

        boolean verficacao = true;

        // codigo para verificar se o campo foi preenchido
        if(PrecoGasolina == null || PrecoGasolina.equals("")
                || PrecoAlcool == null || PrecoAlcool.equals("")
        ){
            verficacao = true;

        }else{

            verficacao = false;
        }

        return verficacao;
    }

}