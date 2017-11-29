package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PrimeraPantalla extends AppCompatActivity {

    ImageView imagen;
    Button btnAceptar;
    EditText txtUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        iniciarUI();
    }
    public void iniciarUI() {
        imagen = (ImageView) findViewById(R.id.imgGaleria);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        txtUsu = (EditText) findViewById(R.id.txtUsu);
    }
    public void pulsaAcep(View v) {

        Intent inten = new Intent(getApplicationContext(),SegundaPantalla.class);
        inten.putExtra("nombre",txtUsu.getText());
        startActivity(inten);
    }
    public void pulsaSeleccionar(View v) {
        cargarImagen();
    }


    private void cargarImagen() {
        Intent intencion = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intencion.setType("image/");
        startActivityForResult(intencion.createChooser(intencion,"Selecciona la imagen"),10);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

}