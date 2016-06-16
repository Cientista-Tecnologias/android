package com.example.ac.nyw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

public class Termos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //===============================================================================================
    //Fução dos Botões Radio Grupo
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            //as opções do termo de condições
            case R.id.Concordo:
                if (checked)
                    // Concordo are the best
                    break;
            case R.id.Não_Concordo:
                if (checked)
                    // Não Concordo rule
                    break;
                //as opções da Reserva
            case R.id.Delivery:
                if (checked)
                    // Não Concordo rule
                    break;
            case R.id.Retirada:
                if (checked)
                    // Não Concordo rule
                    break;
        }
    }
    //Função Pesquisa no Filtro*/===================================================================
    public void inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }/////////////////
}
