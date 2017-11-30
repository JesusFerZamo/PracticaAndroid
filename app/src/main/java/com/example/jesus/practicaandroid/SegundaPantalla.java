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

    ListView lst;
    TextView lblPrinci;
    static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
    }
    public void iniciarUI(){
        final String[] datos = new String[]{"Acceso a Datos","Android Studio","Desarrollo de Interfaces"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, datos);

        /*
        final String[] datos = new String[]{"Acceso a Datos","Android Studio","Desarrollo de Interfaces"};
        final Integer[] img = new Integer[]{R.drawable.java,R.drawable.c,R.drawable.go};
        ArrayAdapter adaptador = new ArrayAdapter(this, datos, img);
        */

        //btnAcep = (Button) findViewById(R.id.btnAcep);
        lst = (ListView) findViewById(R.id.lstOpc);
        lblPrinci = (TextView) findViewById(R.id.lblPrinci);

        lst.setAdapter(adaptador);

        lst.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            // Abre una nueva Activity:
                            Intent intencion1 = new Intent(view.getContext(), TerceraPantalla.class);
                            intencion1.putExtra("nombre",nombre);
                            startActivity(intencion1);
                        } else if (position == 1) {
                            // Abre una nueva Activity:
                            //Intent inten2 = new Intent(view.getContext(), TerceraPantalla.class);
                            //startActivity(inten2);
                        }
                    }
                } );
    }

}
