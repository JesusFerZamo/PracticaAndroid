package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuintaPantalla extends AppCompatActivity {

    RadioGroup rd1;
    RadioGroup rd3;
    RadioGroup rd4;

    Button btnAcep1;
    RadioButton rb1_3c;
    CheckBox ch1c;
    CheckBox ch2c;
    CheckBox ch3c;
    CheckBox ch4c;
    RadioButton rb2_3c;
    RadioButton rb3_2c;
    TextView lblTest1c;

    Integer correcta = 0;
    Integer incorrecta = 0;
    String correc;
    String incorrec;
    String txtBien;
    String txtMal;
    String txtSelec;
    String titulo;

    static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }

    public void iniciarUI(){
        rd1 = (RadioGroup) findViewById(R.id.rd1);
        rd3 = (RadioGroup) findViewById(R.id.rd3);
        rd4 = (RadioGroup) findViewById(R.id.rd4);
        btnAcep1 = (Button) findViewById(R.id.btnAcep);
        rb1_3c = (RadioButton) findViewById(R.id.rb1_3c);
        ch1c = (CheckBox) findViewById(R.id.ch1c);
        ch2c = (CheckBox) findViewById(R.id.ch2c);
        ch3c = (CheckBox) findViewById(R.id.ch3c);
        ch4c = (CheckBox) findViewById(R.id.ch4c);
        rb2_3c = (RadioButton) findViewById(R.id.rb2_3c);
        rb3_2c = (RadioButton) findViewById(R.id.rb3_2c);
        lblTest1c = (TextView) findViewById(R.id.lblTest1c);
    }

    public void pulsaAcep(View v){
        correcta = 0;
        incorrecta = 0;
        txtSelec = getString(R.string.txtSelec);
        if (rb1_3c.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (ch1c.isChecked() && ch2c.isChecked() && ch4c.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb2_3c.isChecked()) {
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb3_2c.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if ((rd1.getCheckedRadioButtonId() == -1) || (rd3.getCheckedRadioButtonId() == -1)  || (rd4.getCheckedRadioButtonId() == -1) || ((!ch1c.isChecked()) && (!ch2c.isChecked()) && (!ch3c.isChecked()) && (!ch4c.isChecked())))
        {
            Toast.makeText(this, txtSelec, Toast.LENGTH_SHORT).show();
        }
        else{

            if(correcta==4){
                txtBien = getString(R.string.txtBien);
                Toast.makeText(this, txtBien, Toast.LENGTH_SHORT).show();
            }
            if(incorrecta==4){
                txtMal = getString(R.string.txtMal);
                Toast.makeText(this, txtMal, Toast.LENGTH_SHORT).show();
            }

            titulo = getString(R.string.lblTest1c);
            correc = String.valueOf(correcta);
            incorrec = String.valueOf(incorrecta);
            Intent intencion = new Intent(getApplicationContext(),UltimaPantalla.class);
            intencion.putExtra("titulo",titulo);
            intencion.putExtra("nombre",nombre);
            intencion.putExtra("correcta",correc);
            intencion.putExtra("incorrecta",incorrec);
            startActivity(intencion);


        }


        //Toast.makeText(this, "Tienes "+correcta+" preguntas correctas y "+incorrecta+ " preguntas incorrectas", Toast.LENGTH_SHORT).show();

    }
}
