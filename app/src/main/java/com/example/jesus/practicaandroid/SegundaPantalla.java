package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class SegundaPantalla extends AppCompatActivity {

    TextView lblPrinci;
    TextView lblUsu;
    static String nombre;

    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "Acceso a Datos",
            "Android Studio",
            "Desarrollo de Interfaces",
            "Pokemon",
    };

    int[] imagenes = {
            R.drawable.icon01,
            R.drawable.icon02,
            R.drawable.icon03,
            R.drawable.icon04
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        nombre = getIntent().getStringExtra("nombre");
        iniciarUI();
        lblUsu.setText(nombre);
    }
    public void iniciarUI(){
        final ListView lst = (ListView) findViewById(R.id.lstOpc);
        adapter = new ListViewAdapter(this, titulo, imagenes);
        lblPrinci = (TextView) findViewById(R.id.lblPrinci);
        lblUsu = (TextView) findViewById(R.id.lblNombre);

        lst.setAdapter(adapter);

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
                }
        );
    }
}
