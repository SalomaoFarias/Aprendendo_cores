package br.fmu.aprendendo_cores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dificil_1Activity extends AppCompatActivity {
    private int valCor = 0;

    private ImageView voltarMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil1);

        /* Imagem da seta pra esquerda */
        voltarMenu2 = findViewById(R.id.voltarMenu);

        // Troca para a tela Menu
        voltarMenu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               menu();
            }
        });
    }

    public  void  menu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void dificil_II() {
        Intent intent = new Intent(this, Dificil_2Activity.class);
        intent.putExtra("valorcor", valCor);
        startActivity(intent);
    }
}