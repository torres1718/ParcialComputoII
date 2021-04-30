package com.example.parcialcomputoii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class portadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
    }
    public void irLista(View v){

        Intent intent = new Intent(portadaActivity.this, getAllActivity.class);
        startActivity(intent);

    }
}