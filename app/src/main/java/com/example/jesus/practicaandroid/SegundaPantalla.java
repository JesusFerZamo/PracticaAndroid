package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SegundaPantalla extends AppCompatActivity {

    //Button btnAcep;
    ListView lst;
    TextView txtPrinci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        iniciarUI();
    }
    public void iniciarUI(){
        final String[] datos = new String[]{"Acceso a Datos","Android Studio","Desarrollo de Interfaces"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, datos);

        //btnAcep = (Button) findViewById(R.id.btnAcep);
        lst = (ListView) findViewById(R.id.lstOpc);
        txtPrinci = (TextView) findViewById(R.id.txtPrinci);

        String nombre = getIntent().getStringExtra("nombre");
        txtPrinci.setText(nombre);

        lst.setAdapter(adaptador);


        lst.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (position == 0) {
                            // Abre una nueva Activity:
                            Intent myIntent = new Intent(view.getContext(), PrimeraPantalla.class);
                            startActivity(myIntent);
                        } else if (position == 1) {
                            // Abre una nueva Activity:
                            Intent myIntent = new Intent(view.getContext(), TerceraPantalla.class);
                        }
                    }


                } );

    }


}


