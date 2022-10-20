package br.fmu.aprendendo_cores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Dificil_2Activity extends AppCompatActivity {
   private static final int images[] = {R.drawable.dificil.01-Cor-Terciario-Amarelo-Verde,R.drawable.dificil.02-Cor-Terciario-Amarelo-Laranja,
        R.drawable.dificil.03-Cor-Terciario-Vermelho_Laranja, R.drawable.dificil.04-Cor-Terciario-Azul-Verde, R.drawable.dificil.05-Cor-Terciario-Azul-Violeta,
        R.drawable.dificil.06-Cor-Terciario-Vermelho-Violeta}; //Expandir para 6
    private static final int[] buttonImages = {R.drawable.dificil.01-Cor-Terciario-Amarelo-Verde-resp, R.drawable.dificil.02-Cor-Terciario-Amarelo-Laranja-resp, 
        R.drawable.dificil.03-Cor-Terciario-Vermelho_Laranja-Resp, R.drawable.dificil.04-Cor-Terciario-Azul-Verde-Violeta-resp, R.drawable.dificil.05-Cor-Terciario-Azul-Violeta=resp,
        R.drawable.dificil.06-Cor-Terciario-Vermelho-Violeta-resp}; //Expandir para 6
    private int seq1[] = new int[buttonImages.length];
    private int seq2[] = new int[4];
    private int valCor = 0;
    private ImageView voltarMenu;
    private ImageView cor;
    private ImageView btn1;
    private ImageView btn2;
    private ImageView btn3; 
    private ImageView btn4; 
    private ImageView check01;
    private ImageView check02;
    private ImageView check03;
    private ImageView check04;
    private ImageView recarregarBtn;
    private ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil2);

        /* verificar qual modo(nuturno ou diurno) está ativado */

        /* Imagem da seta pra esquerda */
        voltarMenu = findViewById(R.id.voltarMenuDifi2);
        
        // Troca para a tela Menu
        voltarMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                menu();
            }
        });

        /* Obter a cor selecionada e puxar a imagem relacionada */
        Bundle extras = getIntent().getExtras(); 
        if (extras != null) {
            Intent intent = getIntent();
            valCor = intent.getIntExtra("valorcor");
        }

        // Salvar valCor em seq[0]
        seq1[0] = valCor;
        valCor = 0;
        sequencia(seq1);
        
        cor.findViewById(R.id.cor);
        cor.setImageResource(seq1[valCor]);

        sequencia2(seq2);

        btn1 = findViewById(R.id.btn1Difi2); 
        btn2 = findViewById(R.id.btn2Difi2);  
        btn3 = findViewById(R.id.btn3Difi2);
        btn4 = findViewById(R.id.btn4Difi2); 

        btn1.setImageResource(buttonImages[seq2[0]]);
        btn2.setImageResource(buttonImages[seq2[1]]);
        btn3.setImageResource(buttonImages[seq2[2]]);
        btn4.setImageResource(buttonImages[seq2[3]]);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
               opcao1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
               opcao2();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
               opcao3();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
               opcao4();
            }
        });

        check01 = findViewById(R.id.check01);
        check02 = findViewById(R.id.check02);
        check03 = findViewById(R.id.check03);
        check04 = findViewById(R.id.check04);
        // Tornar checks invisiveis 
        invisivel();

        /* Reset botões */
        recarregarBtn = findViewById(R.id.recarregarBtnDifi2);
        // Tornar invisivel 
        recarregarBtn.setVisibility(View.INVISIBLE);

        recarregarBtn.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
                // onCreate();
                reset();
            }
        });

        /* Botão next*/
        next.findViewById(R.id.nextDifi2);
        // Tornar invisivel 
        next.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener(){
            @Overrride
            public void onClick(View v) {
               proximo();
            }
        });
    }

    public  void  menu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void sequencia(int x[]) {
        Random rand = new Random();
        for (int i = 1; i < images.length; i++) {
            do{
                x[i] = rand.nextInt(images.length); 
            } while (x[i] == x[0] && x[i] == x[1] && x[i] == x[2] && x[i] == x[3] && x[i] == x[4] && x[i] == x[5]);
        }
    }

    public void sequencia2(int x[]) {
        Random ran = new Random();
        int temp = ran.nextInt(seq2.length);
        seq2[temp] = seq1[valCor];
        for (int i = 0; i < seq2.length; i++) {
            do{
                if (i != temp) {
                    x[i] = rand.nextInt(images.length);
                } else {}
            } while (x[i] == x[0] && x[i] == x[1] && x[i] == x[2]);
        }
    }

    public void invisivel() {
        check01.setVisibility(View.INVISIBLE);
        check02.setVisibility(View.INVISIBLE);
        check03.setVisibility(View.INVISIBLE);
        check04.setVisibility(View.INVISIBLE);
    }

    public void visivel() {
        check01.setVisibility(View.VISIBLE);
        check02.setVisibility(View.VISIBLE);
        check03.setVisibility(View.VISIBLE);
        check04.setVisibility(View.VISIBLE);
    }

	public void opcao1() {
        // Verificar opção e mudar de cor
        if (seq2[0] == seq1[valCor]) {            
            check01.setImageResource(R.drawable.outros.check);
            if (check01.Visibility != VISIBLE) {
                // Tornar imagem/botão de proxima tela visivel 
                next.setVisibility(View.VISIBLE);
            }
        } else {
            if (seq2[1] == seq1[valCor]) {
                check02.setImageResource(R.drawable.outros.check);
            } if else (seq2[2] == seq1[valCor]) {
                check03.setImageResource(R.drawable.outros.check);
            } else {
                check04.setImageResource(R.drawable.outros.check);
            } 

            // Tornar imagem/botão de resetar a tela visivel
            recarregarBtn.setVisibility(View.VISIBLE);
        }
        // Tornar checks visiveis
        visivel();
    }

    public void opcao2() {
        // Verificar opção e mudar de cor
        if (seq2[1] == seq1[valCor]) {            
            check02.setImageResource(R.drawable.outros.check);
            if (check02.Visibility != VISIBLE) {
                // Tornar imagem/botão de proxima tela visivel 
                next.setVisibility(View.VISIBLE);
            }
        } else {
            if (seq2[0] == seq1[valCor]) {
                check01.setImageResource(R.drawable.outros.check);
            } if else (seq2[2] == seq1[valCor]) {
                check03.setImageResource(R.drawable.outros.check);
            } else {
                check04.setImageResource(R.drawable.outros.check);
            } 

            // Tornar imagem/botão de resetar a tela visivel
            recarregarBtn.setVisibility(View.VISIBLE);
        }
        // Tornar checks visiveis
        visivel();
    }    

    public void opcao3() {
        // Verificar opção e mudar de cor
        if (seq2[2] == seq1[valCor]) {            
            check03.setImageResource(R.drawable.outros.check);
            if (check02.Visibility != VISIBLE) {
                // Tornar imagem/botão de proxima tela visivel 
                next.setVisibility(View.VISIBLE);
            }
        } else {
            if (seq2[0] == seq1[valCor]) {
                check01.setImageResource(R.drawable.outros.check);
            } if else (seq2[1] == seq1[valCor]) {
                check02.setImageResource(R.drawable.outros.check);
            } else {
                check04.setImageResource(R.drawable.outros.check);
            } 

            // Tornar imagem/botão de resetar a tela visivel
            recarregarBtn.setVisibility(View.VISIBLE);
        }
        // Tornar checks visiveis
        visivel();
    }

    public void opcao4() {
        // Verificar opção e mudar de cor
        if (seq2[3] == seq1[valCor]) {            
            check04.setImageResource(R.drawable.outros.check);
            if (check02.Visibility != VISIBLE) {
                // Tornar imagem/botão de proxima tela visivel 
                next.setVisibility(View.VISIBLE);
            }
        } else {
            if (seq2[0] == seq1[valCor]) {
                check01.setImageResource(R.drawable.outros.check);
            } if else (seq2[1] == seq1[valCor]) {
                check02.setImageResource(R.drawable.outros.check);
            } else {
                check03.setImageResource(R.drawable.outros.check);
            } 

            // Tornar imagem/botão de resetar a tela visivel
            recarregarBtn.setVisibility(View.VISIBLE);
        }
        // Tornar checks visiveis
        visivel();
    }

    public void reset() {
        // Tornar checks invisiveis
        invisivel();
        // Tornar imagem/botão de resetar a tela invisivel
        recarregarBtn.setVisibility(View.INVISIBLE);
    }

    public void proximo() {
        // Tornar checks invisiveis
        invisivel();

        check01.setImageResource(R.drawable.outros.x);
        check02.setImageResource(R.drawable.outros.x);
        check03.setImageResource(R.drawable.outros.x);
        check04.setImageResource(R.drawable.outros.x);
        // Incrementar valCor para trocar a imagem da cor
        valCor++;
        if (valCor >= images.length) {
            next.setVisibility(View.INVISIBLE);

            Intent intent = new Intent( this, Parabens.class);
            startActivity(intent);
        } else {
            imageView.setImageResource(images[seq1[valCor]]);
            // Trocar imagens dos botões
            sequencia2(seq2);
            btn1.setImageResource(buttonImages[seq2[0]]);
            btn2.setImageResource(buttonImages[seq2[1]]);
            btn3.setImageResource(buttonImages[seq2[2]]);
            btn4.setImageResource(buttonImages[seq2[3]]);
            // tornar botão proximo invisivel
            next.setVisibility(View.INVISIBLE);
        }
    }
}
