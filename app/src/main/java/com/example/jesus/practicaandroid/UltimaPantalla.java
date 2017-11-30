package com.example.jesus.practicaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UltimaPantalla extends AppCompatActivity {

    TextView lblUsu;
    TextView lblCorrecta;
    TextView lblIncorrecta;
    Button btn;
    ImageView img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima_pantalla);
        //Intent intent = getIntent();
        String nombre = getIntent().getStringExtra("nombre");
        String correcta = getIntent().getStringExtra("correcta");
        String incorrecta = getIntent().getStringExtra("incorrecta");
        //Uri uri = intent.getParcelableExtra("imagen");
        //Bitmap bitmap = intent.getParcelableExtra("bitMap");
        iniciarUI();
        lblUsu.setText(nombre);
        lblCorrecta.setText("Correctas: "+correcta);
        lblIncorrecta.setText("Incorrectas: "+incorrecta);
        //img.setImageURI(uri);
        //img.setImageBitmap(bitmap);
    }

    public void iniciarUI() {
        lblUsu = (TextView) findViewById(R.id.lblUsu);
        lblCorrecta = (TextView) findViewById(R.id.lblCorrec);
        lblIncorrecta = (TextView) findViewById(R.id.lblIncorrec);
        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btn);
    }
}
