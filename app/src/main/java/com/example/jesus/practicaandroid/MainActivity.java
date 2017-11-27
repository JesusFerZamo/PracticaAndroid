package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarUI();
    }
    public void iniciarUI(){
        btn = (Button) findViewById(R.id.btnAcep);
    }
    public void pulsaBoton(View v){
        Intent intencion = new Intent(getApplicationContext(),SegundaPantalla.class);
        startActivity(intencion);
    }

}
