package com.example.marcadordeplacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tempo;
    private EditText nomeA;
    private EditText nomeB;
    private EditText objetivo;
    private Button comecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempo = findViewById(R.id.txtTempo);
        nomeA = findViewById(R.id.txtNomeA);
        nomeB = findViewById(R.id.txtNomeB);
        objetivo = findViewById(R.id.txtObjetivo);
        comecar = findViewById(R.id.btnStart);

        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //String tempoString = tempo.getText().toString();
                //double tempoDouble = Double.parseDouble(tempoString);
                //if (tempoDouble < 0){tempo.setError("Informe um tempo maior que zero");return;}
                //formatarTempo(tempoDouble);

                String nomeAString = nomeA.getText().toString();
                String nomeBString = nomeB.getText().toString();
                if(objetivo.getText().toString().isEmpty()){
                    objetivo.setError("Insira pelo menos um gol");
                    return;
                }
                String objetivoString = objetivo.getText().toString();
                int objetivoInt = Integer.parseInt(objetivoString);
                if (objetivoInt <= 0){
                    objetivo.setError("Insira pelo menos um gol");return;}


                Intent intent = new Intent(MainActivity.this, PartidaActivity.class);
                //intent.putExtra("Tempo", tempoDouble);
                intent.putExtra("NomeA", nomeAString);
                intent.putExtra("NomeB", nomeBString);
                intent.putExtra("Objetivo", objetivoInt);
                //intent.putExtra("Tempo", tempoDouble);
                startActivity(intent);
            }
        });
    }

    private boolean validaCampos() {
        if (tempo.getText().toString().isEmpty()) {
            tempo.setError("Informe o tempo");
            return false;
        }
        if (nomeA.getText().toString().isEmpty()) {
            nomeA.setError("Informe um nome");
            return false;
        }
        if (nomeB.getText().toString().isEmpty()) {
            nomeB.setError("Informe um nome");
            return false;
        }
        if (objetivo.getText().toString().isEmpty()) {
            objetivo.setError("Informe um número de gols");
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        nomeA.setText("");
        nomeB.setText("");
        objetivo.setText("");
        nomeA.requestFocus();
        nomeB.requestFocus();
        objetivo.requestFocus();
    }
    private double formatarTempo(double tempo){
         return 60*tempo*1000;
    }

}
