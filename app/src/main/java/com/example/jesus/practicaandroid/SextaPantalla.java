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

public class SextaPantalla extends AppCompatActivity {

    RadioGroup rd1;
    RadioGroup rd3;
    RadioGroup rd4;

    Button btnAcep1;
    RadioButton rb1_2p;
    CheckBox ch1p;
    CheckBox ch2p;
    CheckBox ch3p;
    CheckBox ch4p;
    RadioButton rb2_2p;
    RadioButton rb3_2p;
    TextView lblTest1p;

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
        setContentView(R.layout.activity_sexta_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }

    public void iniciarUI(){
        rd1 = (RadioGroup) findViewById(R.id.rd1);
        rd3 = (RadioGroup) findViewById(R.id.rd3);
        rd4 = (RadioGroup) findViewById(R.id.rd4);
        btnAcep1 = (Button) findViewById(R.id.btnAcep);
        rb1_2p = (RadioButton) findViewById(R.id.rb1_2p);
        ch1p = (CheckBox) findViewById(R.id.ch1p);
        ch2p = (CheckBox) findViewById(R.id.ch1p);
        ch3p = (CheckBox) findViewById(R.id.ch3p);
        ch4p = (CheckBox) findViewById(R.id.ch4p);
        rb2_2p = (RadioButton) findViewById(R.id.rb2_2p);
        rb3_2p = (RadioButton) findViewById(R.id.rb3_2p);
        lblTest1p = (TextView) findViewById(R.id.lblTest1p);
    }

    public void pulsaAcep(View v){
        correcta = 0;
        incorrecta = 0;
        txtSelec = getString(R.string.txtSelec);
        if (rb1_2p.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (ch1p.isChecked() && ch2p.isChecked() && ch4p.isChecked()  ){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb2_2p.isChecked()) {
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb3_2p.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if ((rd1.getCheckedRadioButtonId() == -1) || (rd3.getCheckedRadioButtonId() == -1)  || (rd4.getCheckedRadioButtonId() == -1) || ((!ch1p.isChecked()) && (!ch2p.isChecked()) && (!ch3p.isChecked()) && (!ch4p.isChecked())))
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

            titulo = getString(R.string.lblTest1p);
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
