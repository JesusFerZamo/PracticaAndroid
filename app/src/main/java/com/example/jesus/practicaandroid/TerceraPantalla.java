package com.example.jesus.practicaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TerceraPantalla extends AppCompatActivity {

    Button btnAcep1;
    RadioButton rb3;
    TextView lblPreg1;

    Integer correcta = 0;
    Integer incorrecta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);
        iniciarUI();
    }
    public void iniciarUI(){
        btnAcep1 = (Button) findViewById(R.id.btnAcep1);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        lblPreg1 = (TextView) findViewById(R.id.lblPreg1);
    }
    public void pulsaAcep(View v){
        RadioGroup rd1 = (RadioGroup) findViewById(R.id.rd1);

        //String txtCorrecta = rb3.getText().toString();
        String txtCorrecta = "Correcta";
        String txtIncorrecta = "Incorrecta";

        if (rb3.isChecked()){
            Toast.makeText(this, txtCorrecta, Toast.LENGTH_SHORT).show();
            correcta = 1;
        }
        else{
            Toast.makeText(this, txtIncorrecta, Toast.LENGTH_SHORT).show();
            incorrecta = 1;
        }
    }
}
