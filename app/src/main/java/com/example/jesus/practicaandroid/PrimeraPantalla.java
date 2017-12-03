package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrimeraPantalla extends AppCompatActivity {

    Button btnAceptar;
    EditText txtUsu;
    String txtSaludo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        txtSaludo = getResources().getString(R.string.txtSaludo);
        iniciarUI();
    }
    public void iniciarUI() {
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtUsu = (EditText) findViewById(R.id.txtUsu);
    }
    public void pulsaAcep(View v) {
        Toast.makeText(this, txtSaludo+ " "+txtUsu.getText(), Toast.LENGTH_SHORT).show();
        Intent intencion = new Intent(getApplicationContext(),SegundaPantalla.class);
        intencion.putExtra("nombre",txtUsu.getText().toString());
        startActivity(intencion);
    }

    //Tenemos que añadir imagen
}
