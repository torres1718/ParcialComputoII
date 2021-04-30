package com.example.parcialcomputoii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parcialcomputoii.interfarces.ClienteAPI;
import com.example.parcialcomputoii.models.Clientes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
EditText edtId;
TextView tvNombre,tvApellido;
Button btnBuscar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId=findViewById(R.id.edtId);
        tvNombre=findViewById(R.id.tvnombre);
        tvApellido=findViewById(R.id.tvapellido);
        btnBuscar=findViewById(R.id.btnBuscar);


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            find(edtId.getText().toString());
            }
        });

    }

    private void find(String cod){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.1.19/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ClienteAPI clienteAPI=retrofit.create(ClienteAPI.class);
        //llamamos http


        Call<Clientes> call= clienteAPI.find(cod);
        call.enqueue(new Callback<Clientes>() {
            @Override
            public void onResponse(Call<Clientes> call, Response<Clientes> response) {
                try {
                   if(response.isSuccessful()){
                       Clientes clientes=response.body();
                       tvNombre.setText(clientes.getNombre());
                       tvApellido.setText(clientes.getApellido());
                   }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Clientes> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}