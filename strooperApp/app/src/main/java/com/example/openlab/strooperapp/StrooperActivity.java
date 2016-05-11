package com.example.openlab.strooperapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StrooperActivity extends AppCompatActivity {

    TextView txtSegundos,txtNick,txtPuntaje, txtColor;
    EditText nick2;
    String vector_colores[]={"Azul","Verde","Rojo","Amarillo"}, colorPalabra="";

    int correctos=0,intentos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strooper);

        inicializarCampos();

    }

    public void BotonTrue(View view){
        if(txtColor.getText().equals(colorPalabra)){
            Toast.makeText(getBaseContext(), "Correcto", Toast.LENGTH_SHORT).show();
            correctos++;
        }else{
            Toast.makeText(getBaseContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    public void BotonFalse(View view){
        if(!txtColor.getText().equals(colorPalabra)){
            Toast.makeText(getBaseContext(), "Correcto", Toast.LENGTH_SHORT).show();
            correctos++;
        }else{
            Toast.makeText(getBaseContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializarCampos(){
        txtNick = (TextView) findViewById(R.id.txtNick);
        txtPuntaje = (TextView) findViewById(R.id.txtPuntaje);
        txtSegundos = (TextView) findViewById(R.id.txtSegundos);
        txtColor = (TextView) findViewById(R.id.txtColor);

       Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            txtNick.setText(bundle.getString("nick"));
        }else {
            txtNick.setText("");
        }

        txtSegundos.setText("Jugar Ahora");
    }

    public void jugarAhora(View view){
        if(txtSegundos.getText().toString().equalsIgnoreCase("Jugar Ahora")){
            cambiarColorTexto(txtColor);
            cambiarTexto(txtColor);
            inicarCuentaAtras();
        }
    }

    CountDownTimer counter;
    int segundos =3;
    public void inicarCuentaAtras(){
        txtPuntaje.setText(correctos+"");
        txtPuntaje.setText(correctos+" correctos de "+intentos+" intentos");
        txtPuntaje.setText(correctos+" correctos de "+intentos+" intentos");

        counter = new CountDownTimer(5*1000, 1000) {
            @Override
            public void onTick(long miliSegundos) {
                segundos = (int) (miliSegundos / 1000);
                txtSegundos.setText("" + (segundos - 1));
                //Modificado por David A.
                if(txtSegundos.getText().equals("0")){
                    //cambiarColorTexto(txtColor);
                    //cambiarTexto(txtColor);
                }
            }

            @Override
            public void onFinish() {
                cambiarColorTexto(txtColor);
                cambiarTexto(txtColor);
                inicarCuentaAtras();
                intentos++;
            }
        };

        counter.start();
    }

    //Creado por David A.
    public void cambiarColorTexto(TextView colortexto){
        int max=4;
        switch (new Random().nextInt(max)){
            case 0: txtColor.setTextColor(getResources().getColor(R.color.verde));
                colorPalabra="Verde";
                break;
            case 1: txtColor.setTextColor(getResources().getColor(R.color.azul));
                colorPalabra="Azul";
                break;
            case 2: txtColor.setTextColor(getResources().getColor(R.color.amarillo));
                colorPalabra="Amarillo";
                break;
            case 3: txtColor.setTextColor(getResources().getColor(R.color.rojo));
                colorPalabra="Rojo";
                break;
        }

    }

    //Creado por David A.
    public void cambiarTexto(TextView texto){
        texto.setText(vector_colores[new Random().nextInt(4)]);
    }
}
  /*  public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String tiempo = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
            counter.setText(tiempo);
        }

        @Override
        public void onFinish() {
            counter.setText("Finalizado");
        }
    }*/

