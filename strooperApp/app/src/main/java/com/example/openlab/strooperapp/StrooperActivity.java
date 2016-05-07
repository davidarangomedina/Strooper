package com.example.openlab.strooperapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class StrooperActivity extends AppCompatActivity {

    TextView txtSegundos,txtNick,txtPuntaje;
    EditText nick2;

    int correctos=0,intentos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strooper);

        inicializarCampos();

    }

    private void inicializarCampos(){
        txtNick = (TextView) findViewById(R.id.txtNick);
        txtPuntaje = (TextView) findViewById(R.id.txtPuntaje);
        txtSegundos = (TextView) findViewById(R.id.txtSegundos);

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
            }

            @Override
            public void onFinish() {
                inicarCuentaAtras();
                intentos++;
            }
        };

        counter.start();
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

