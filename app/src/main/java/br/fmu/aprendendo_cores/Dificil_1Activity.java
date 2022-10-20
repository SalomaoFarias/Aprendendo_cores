package br.fmu.aprendendo_cores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dificil_1Activity extends AppCompatActivity {
    private int valCor = 0;

    private ImageView voltarMenu;
    private ImageView cor1;
    private ImageView cor2;
    private ImageView cor3;
    private ImageView cor4;
    private ImageView cor5;
    private ImageView cor6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil1);

        /* verificar qual modo(nuturno ou diurno) está ativado */

        /* Imagem da seta pra esquerda */
        voltarMenu = findViewById(R.id.voltarMenuDifi);
        
        // Troca para a tela Menu
        voltarMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                menu();
            }
        });

        /* Opções de cores */
        cor1 = findViewById(R.id.cor1);
        cor2 = findViewById(R.id.cor2);
        cor3 = findViewById(R.id.cor3);
        cor4 = findViewById(R.id.cor4);
        cor5 = findViewById(R.id.cor5);
        cor6 = findViewById(R.id.cor6);

        cor1.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 0;
                dificil_II();
            }
        });

        cor2.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 1;
                dificil_II();
            }
        });

        cor3.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 2;
                dificil_II();
            }
        });

        cor4.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 3;
                dificil_II();
            }
        });

        cor5.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 4;
                dificil_II();
            }
        });

        cor6.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                //Copiar e mandar a cor escolhida para Dificil_II
                valCor = 5;
                dificil_II();
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
