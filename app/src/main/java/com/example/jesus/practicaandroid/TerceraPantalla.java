package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TerceraPantalla extends AppCompatActivity {

    Button btnAcep1;
    RadioButton rb3;
    CheckBox ch3;
    CheckBox ch4;
    RadioButton rb7;
    RadioButton rb10;
    TextView lblPreg1;

    Integer correcta = 0;
    Integer incorrecta = 0;

    static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }
    public void iniciarUI(){
        btnAcep1 = (Button) findViewById(R.id.btnAcep);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        ch3 = (CheckBox) findViewById(R.id.ch3);
        ch4 = (CheckBox) findViewById(R.id.ch4);
        rb7 = (RadioButton) findViewById(R.id.rb7);
        rb10 = (RadioButton) findViewById(R.id.rb10);
        lblPreg1 = (TextView) findViewById(R.id.lblTest1);
    }
    public void pulsaAcep(View v){

        if (rb3.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (ch3.isChecked() && ch4.isChecked() ){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (rb7.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (rb10.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        Toast.makeText(this, "Tienes "+correcta+" preguntas correctas y "+incorrecta+ " preguntas incorrectas", Toast.LENGTH_SHORT).show();
        Intent intencion = new Intent(getApplicationContext(),UltimaPantalla.class);
        intencion.putExtra("nombre",nombre);
        startActivity(intencion);
    }
}
