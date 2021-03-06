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
import com.example.parcialcomputoii.remote.CLIENTEUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText etId, etName, etApellido;
    TextView tvResponse;
    Button btnSave, btnEdit;

    //Llamamos a la interfaz ClienteAPI
    private ClienteAPI clienteAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId=findViewById(R.id.et_id);
        etName=findViewById(R.id.et_nombre);
        etApellido=findViewById(R.id.et_apellido);
        tvResponse=findViewById(R.id.tvResponse);
        btnSave=findViewById(R.id.btnSave);
        btnEdit=findViewById(R.id.btnEdit);

        clienteAPI = CLIENTEUtils.getClientAPI();

        //Boton guardar
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty() && etApellido.getText().toString().isEmpty()){
                    return;
                }

                //Llamada al metodo
                saveClientes(etName.getText().toString(), etApellido.getText().toString());
            }
        });

        //Boton para actualizar
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editClientes(etId.getText().toString(), etName.getText().toString(), etApellido.getText().toString() );
            }
        });

    }

    public void saveClientes(String nombre, String apellido){

        Clientes clientes = new Clientes(nombre, apellido);

        //Llamamos al metodo de la interfaz ClienteAPI
        clienteAPI.saveClientes(clientes).enqueue(new Callback<Clientes>() {
            @Override
            public void onResponse(Call<Clientes> call, Response<Clientes> response) {

                Clientes responseClientes = response.body();
                String responseString = "Response code:" + response.code() +
                        "\nData:" + clientes.toString();

                //Se muestra en el TextView en el response
                showResponse(responseString.toString());
            }

            @Override
            public void onFailure(Call<Clientes> call, Throwable t) {
                showResponse(t.getMessage());
            }
        });

    }

    public void editClientes(String id, String nombre, String apellido){

        Clientes clientes = new Clientes(id, nombre, apellido);

        //Llamamos al metodo de la interfaz ClienteAPI
        clienteAPI.updateClientes(clientes).enqueue(new Callback<Clientes>() {
            @Override
            public void onResponse(Call<Clientes> call, Response<Clientes> response) {

                Clientes responseClientes = response.body();
                String responseString = "Response code:" + response.code() +
                        "\nData:" + clientes.toString();

                //Se muestra en el TextView en el response
                showResponse(responseString.toString());
            }

            @Override
            public void onFailure(Call<Clientes> call, Throwable t) {
                showResponse(t.getMessage());
            }
        });
    }

    public void showResponse(String response){

        if(tvResponse.getVisibility()==View.GONE){
            tvResponse.setVisibility(View.VISIBLE);
        }
        tvResponse.setText(response);
    }

}