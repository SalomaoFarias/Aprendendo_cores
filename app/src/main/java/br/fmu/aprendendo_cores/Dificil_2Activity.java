package br.fmu.aprendendo_cores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Dificil_2Activity extends AppCompatActivity {
    private int valCor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil2);

        /* Obter a cor selecionada e puxar a imagem relacionada */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            valCor = intent.getIntExtra("valorcor", valCor);
        }
    }
}