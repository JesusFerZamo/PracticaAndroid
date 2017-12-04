package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TerceraPantalla extends AppCompatActivity {

    RadioGroup rd1;
    RadioGroup rd3;
    RadioGroup rd4;

    Button btnAcep1;
    RadioButton rb1_1;
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    RadioButton rb2_1;
    RadioButton rb3_4;
    TextView lblTest1;

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
        setContentView(R.layout.activity_tercera_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }

    public void iniciarUI(){
        rd1 = (RadioGroup) findViewById(R.id.rd1);
        rd3 = (RadioGroup) findViewById(R.id.rd3);
        rd4 = (RadioGroup) findViewById(R.id.rd4);
        btnAcep1 = (Button) findViewById(R.id.btnAcep);
        rb1_1 = (RadioButton) findViewById(R.id.rb1_1);
        ch1 = (CheckBox) findViewById(R.id.ch1);
        ch2 = (CheckBox) findViewById(R.id.ch2);
        ch3 = (CheckBox) findViewById(R.id.ch3);
        ch4 = (CheckBox) findViewById(R.id.ch4);
        rb2_1 = (RadioButton) findViewById(R.id.rb2_1);
        rb3_4 = (RadioButton) findViewById(R.id.rb3_4);
        lblTest1 = (TextView) findViewById(R.id.lblTest1);
    }

    public void pulsaAcep(View v){
        correcta = 0;
        incorrecta = 0;
        txtSelec = getString(R.string.txtSelec);
        if (rb1_1.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (ch2.isChecked() && ch3.isChecked()&& ch4.isChecked()  ){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb2_1.isChecked()) {
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb3_4.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if ((rd1.getCheckedRadioButtonId() == -1) || (rd3.getCheckedRadioButtonId() == -1)  || (rd4.getCheckedRadioButtonId() == -1) || ((!ch1.isChecked()) && (!ch2.isChecked()) && (!ch3.isChecked()) && (!ch4.isChecked())))
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

            titulo = getString(R.string.lblTest1);
            correc = String.valueOf(correcta);
            incorrec = String.valueOf(incorrecta);
            Intent intencion = new Intent(getApplicationContext(),UltimaPantalla.class);
            intencion.putExtra("titulo",titulo);
            intencion.putExtra("nombre",nombre);
            intencion.putExtra("correcta",correc);
            intencion.putExtra("incorrecta",incorrec);
            startActivity(intencion);
        }
    }
}
