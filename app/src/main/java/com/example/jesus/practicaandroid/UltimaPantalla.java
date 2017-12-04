package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UltimaPantalla extends AppCompatActivity {

    TextView lblTest1;
    TextView lblUsu;
    TextView lblCorrecta;
    TextView lblIncorrecta;
    Button btnVolver;
    Button btnUrl;
    String nombre;
    String titulo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima_pantalla);

        titulo = getIntent().getStringExtra("titulo");
        nombre = getIntent().getStringExtra("nombre");
        String correcta = getIntent().getStringExtra("correcta");
        String incorrecta = getIntent().getStringExtra("incorrecta");

        iniciarUI();

        lblTest1.setText(titulo);
        lblUsu.setText(nombre);
        lblCorrecta.append(" " + correcta);
        lblIncorrecta.append(" " + incorrecta);
    }

    public void iniciarUI() {
        lblTest1 = (TextView) findViewById(R.id.lblTest1);
        lblUsu = (TextView) findViewById(R.id.lblUsuario);
        lblCorrecta = (TextView) findViewById(R.id.lblCorrec);
        lblIncorrecta = (TextView) findViewById(R.id.lblIncorrec);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnUrl = (Button) findViewById(R.id.btnUrl);
    }

    public void pulsaTest(View v){
        Intent intencion = new Intent(getApplicationContext(),SegundaPantalla.class);
        intencion.putExtra("nombre",nombre);
        startActivity(intencion);
    }

    public void pulsaUsuario(View v){
        //Para pasar a la primera pantalla
        Intent inten = new Intent(getApplicationContext(),PrimeraPantalla.class);
        startActivity(inten);
    }

    public void pulsaSoluciones(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://drive.google.com/file/d/1xzaNZ-f7gnsOR9YPsXVBMkEoSl17Q-tU/view?usp=sharing"));
        startActivity(intent);
    }

}
