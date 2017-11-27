package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SegundaPantalla extends AppCompatActivity {
    Button btnAcep;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        iniciarUI();
    }
    public void iniciarUI(){
        final String[] datos = new String[]{"Acceso a Datos","Android Studio","Desarrollo de Interfaces"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, datos);

        btnAcep = (Button) findViewById(R.id.btnAcep);
        lst = (ListView) findViewById(R.id.lstOpc);

        lst.setAdapter(adaptador);
    }
    public void pulsaBoton(View v){
        Intent intencion = new Intent(getApplicationContext(),TerceraPantalla.class);
        startActivity(intencion);
    }
}
