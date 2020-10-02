package com.example.marcadordeplacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PartidaActivity extends AppCompatActivity {
    private double tempoDaPartida = 0;
    private int objetivoFinal = 0;
    private int contadorGolA = 0;
    private int contadorGolB = 0;
    private int contadorChuteA = 0;
    private int contadorChuteB = 0;
    private int contadorFaltaA = 0;
    private int contadorFaltaB = 0;
    private TextView tempoPartida;
    private TextView timeA;
    private TextView timeB;
    private Button criar;
    private TextView golA;
    private TextView golB;
    private Button addGolA;
    private Button addGolB;
    private TextView chuteA;
    private TextView chuteB;
    private Button addChuteA;
    private Button addChuteB;
    private TextView faltaA;
    private TextView faltaB;
    private Button addFaltaA;
    private Button addFaltaB;
    private TextView vencedor;
    private Button iniciarPartida;
    private Button reinicarPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        iniciarPartida = findViewById(R.id.btnIniciar);
        reinicarPartida = findViewById(R.id.btnReiniciar);
        tempoPartida = findViewById(R.id.txtConometro);
        timeA = findViewById(R.id.txtTimeA);
        timeB = findViewById(R.id.txtTimeB);
        criar = findViewById(R.id.btnCriar);
        golA = findViewById(R.id.txtGolsA);
        golB = findViewById(R.id.txtGolsB);
        addGolA = findViewById(R.id.btnGolA);
        addGolB = findViewById(R.id.btnGolB);
        chuteA = findViewById(R.id.txtChutesA);
        chuteB = findViewById(R.id.txtChutesB);
        addChuteA = findViewById(R.id.btnChuteA);
        addChuteB = findViewById(R.id.btnChuteB);
        faltaA = findViewById(R.id.txtFaltasA);
        faltaB = findViewById(R.id.txtFaltasB);
        addFaltaA = findViewById(R.id.btnFaltaA);
        addFaltaB = findViewById(R.id.btnFaltaB);
        vencedor = findViewById(R.id.txtVencedor);

        Intent intent = getIntent();
        Double tempo = intent.getDoubleExtra("Tempo",0);
        String nomeA = intent.getStringExtra("NomeA");
        String nomeB = intent.getStringExtra("NomeB");
        int objetivo = intent.getIntExtra("Objetivo",0);
        objetivoFinal = objetivo;
        tempoDaPartida = tempo;

        timeA.setText(nomeA);
        timeB.setText(nomeB);

        iniciarPartida();
        addGolA();
        addGolB();
        addChuteA();
        addChuteB();
        addFaltaA();
        addFaltaB();
        reiniciarPartida();
        criarNovaPartida();





    }
        private void criarNovaPartida(){
        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
        private void addGolA(){
            addGolA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    contadorGolA++;
                    String contador = String.valueOf(contadorGolA);
                    golA.setText(contador);
                }
            });
        }
        private void addGolB(){
        addGolB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorGolB++;
                String contador = String.valueOf(contadorGolB);
                golB.setText(contador);
            }
        });
    }
        private void addChuteA(){
        addChuteA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorChuteA++;
                String contador = String.valueOf(contadorChuteA);
                chuteA.setText(contador);
            }
        });
        }
        private void addChuteB(){
        addChuteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorChuteB++;
                String contador = String.valueOf(contadorChuteB);
                chuteB.setText(contador);
            }
        });
    }
        private void contagem() {
            new CountDownTimer(10000, 1000) {
                public void onTick(long millisUntilFinished) {
                    String contagem = String.valueOf(millisUntilFinished / 1000);
                        if (objetivoFinal == contadorGolA) {
                            cancel();
                            onFinish();
                        }
                    tempoPartida.setText(contagem);
                }
                public void onFinish() {
                    if (contadorGolA > contadorGolB){
                        vencedor.setText(timeA.getText());
                    }else if(contadorGolA == contadorGolB){
                        vencedor.setText("Empate");
                    }else{
                        vencedor.setText(timeB.getText());
                    }
                }
            }.start();
        }
        private void iniciarPartida(){
        iniciarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golA.setText("0");
                golB.setText("0");
                chuteA.setText("0");
                chuteB.setText("0");
                faltaA.setText("0");
                faltaB.setText("0");
                contagem();
            }
        });
        }
        private void reiniciarPartida(){
            reinicarPartida.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    golA.setText("-");
                    golB.setText("-");
                    chuteA.setText("-");
                    chuteB.setText("-");
                    faltaA.setText("-");
                    faltaB.setText("-");
                    vencedor.setText("-");
                    contadorGolA = 0;
                    contadorGolB = 0;
                    contadorChuteA = 0;
                    contadorChuteB = 0;
                    contadorFaltaA = 0;
                    contadorFaltaB = 0;

                }
            });


        }
        private void addFaltaA(){
        addFaltaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorFaltaA++;
                String contador = String.valueOf(contadorFaltaA);
                faltaA.setText(contador);
            }
        });
        }
        private void addFaltaB(){
            addFaltaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contadorFaltaB++;
                    String contador = String.valueOf(contadorFaltaB);
                    faltaB.setText(contador);
                }
            });
    }
}