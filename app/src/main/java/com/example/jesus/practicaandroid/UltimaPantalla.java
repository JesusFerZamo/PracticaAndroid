package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UltimaPantalla extends AppCompatActivity {

    TextView lblUsu;
    TextView lblCorrecta;
    TextView lblIncorrecta;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima_pantalla);

        String nombre = getIntent().getStringExtra("nombre");
        String correcta = getIntent().getStringExtra("correcta");
        String incorrecta = getIntent().getStringExtra("incorrecta");

        iniciarUI();
        lblUsu.setText(nombre);
        lblCorrecta.setText("Correctas: "+correcta);
        lblIncorrecta.setText("Incorrectas: "+incorrecta);
    }

    public void iniciarUI() {
        lblUsu = (TextView) findViewById(R.id.lblUsu);
        lblCorrecta = (TextView) findViewById(R.id.lblCorrec);
        lblIncorrecta = (TextView) findViewById(R.id.lblIncorrec);
        btn = (Button) findViewById(R.id.btn);
    }
    
    public void pulsaSoluciones(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://drive.google.com/file/d/0BxDCvxIkltYsNV9sZFh5RGxnUVE/view?usp=sharing"));
        startActivity(intent);
    }

}
