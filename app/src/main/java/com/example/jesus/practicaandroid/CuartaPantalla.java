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

public class CuartaPantalla extends AppCompatActivity {

    RadioGroup rd1;
    RadioGroup rd3;
    RadioGroup rd4;

    Button btnAcep1;
    RadioButton rb1_3h;
    CheckBox ch1h;
    CheckBox ch2h;
    CheckBox ch3h;
    CheckBox ch4h;
    RadioButton rb2_2h;
    RadioButton rb3_1h;
    TextView lblPreg1;

    Integer correcta = 0;
    Integer incorrecta = 0;
    String correc;
    String incorrec;
    String txtBien;
    String txtMal;
    String txtSelec;

    static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }

    public void iniciarUI(){
        rd1 = (RadioGroup) findViewById(R.id.rd1);
        rd3 = (RadioGroup) findViewById(R.id.rd3);
        rd4 = (RadioGroup) findViewById(R.id.rd4);
        btnAcep1 = (Button) findViewById(R.id.btnAcep);
        rb1_3h = (RadioButton) findViewById(R.id.rb1_3h);
        ch1h = (CheckBox) findViewById(R.id.ch1h);
        ch2h = (CheckBox) findViewById(R.id.ch2h);
        ch3h = (CheckBox) findViewById(R.id.ch3h);
        ch4h = (CheckBox) findViewById(R.id.ch4h);
        rb2_2h = (RadioButton) findViewById(R.id.rb2_2h);
        rb3_1h = (RadioButton) findViewById(R.id.rb3_1h);
        lblPreg1 = (TextView) findViewById(R.id.lblTest1);
    }

    public void pulsaAcep(View v){
        correcta = 0;
        incorrecta = 0;
        txtSelec = getString(R.string.txtSelec);
        if (rb1_3h.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }
        if (ch2h.isChecked() && ch3h.isChecked() ){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb2_2h.isChecked()) {
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if (rb3_1h.isChecked()){
            correcta += 1;
        }
        else{
            incorrecta += 1;
        }

        if ((rd1.getCheckedRadioButtonId() == -1) || (rd3.getCheckedRadioButtonId() == -1)  || (rd4.getCheckedRadioButtonId() == -1) || ((!ch1h.isChecked()) && (!ch2h.isChecked()) && (!ch3h.isChecked()) && (!ch4h.isChecked())))
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

            correc = String.valueOf(correcta);
            incorrec = String.valueOf(incorrecta);
            Intent intencion = new Intent(getApplicationContext(),UltimaPantalla.class);
            intencion.putExtra("nombre",nombre);
            intencion.putExtra("correcta",correc);
            intencion.putExtra("incorrecta",incorrec);
            startActivity(intencion);


        }


        //Toast.makeText(this, "Tienes "+correcta+" preguntas correctas y "+incorrecta+ " preguntas incorrectas", Toast.LENGTH_SHORT).show();

    }
}
