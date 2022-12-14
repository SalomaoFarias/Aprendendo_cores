package br.fmu.aprendendo_cores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SetDificuldadeActivity extends AppCompatActivity {
    private ImageView voltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_dificuldade);

        /* verificar qual modo(nuturno ou diurno) está ativado */

        /* Imagem da seta pra esquerda */
        voltarMenu = findViewById(R.id.voltarMenu);

        // Troca para a tela Menu
        voltarMenu.setOnClickListener(new View.OnClickListener(){
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

    public void facil(View view) {
        Intent intent = new Intent(this, FacilActivity.class );
        startActivity(intent);
    }

    public void intermediario(View view) {
        Intent intent = new Intent( this, IntermediarioActivity.class);
        startActivity(intent);
    }

    public void dificil_I(View view) {
        Intent intent = new Intent( this, Dificil_1Activity.class);
        startActivity(intent);
    }
}
