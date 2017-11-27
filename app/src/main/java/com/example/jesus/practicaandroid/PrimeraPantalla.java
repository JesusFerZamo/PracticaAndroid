package com.example.jesus.practicaandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PrimeraPantalla extends AppCompatActivity {

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        iniciarUI();
    }
    public void iniciarUI() {
        imagen = (ImageView) findViewById(R.id.imgGaleria);
    }

    public void pulsaSeleccionar(View v) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intencion = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intencion.setType("image/");
        startActivityForResult(intencion.createChooser(intencion,"Selecciona la imagen"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }
}
